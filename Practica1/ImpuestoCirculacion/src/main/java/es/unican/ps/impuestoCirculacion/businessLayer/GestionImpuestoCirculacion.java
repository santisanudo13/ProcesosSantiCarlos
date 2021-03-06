package es.unican.ps.impuestoCirculacion.businessLayer;


import java.util.List;

import es.unican.ps.common.ILifecycle;
import es.unican.ps.impuestoCirculacion.daoLayer.IContribuyentesDAO;
import es.unican.ps.impuestoCirculacion.daoLayer.IVehiculosDAO;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;



public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, ILifecycle {

	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;

	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}

	/**
	 * A�ade un nuevo contribuyente al sistema.
	 * @param c Contribuyente que se a�ade
	 * @return El contribuyente a�adido
	 * 		   null si no se a�ade porque ya existe
	 */

	public Contribuyente altaContribuyente(Contribuyente c) {
		if(contribuyentes.datosContribuyente(c.getDni()) != null){
			return null;
		}else{
			Contribuyente cont = contribuyentes.nuevoContribuyente(c);
			finaliza();
			return cont;

		}
	}

	/**
	 * Elimina el contribuyente cuyo dni se pasas como par�metro
	 * del sistema.
	 * @param dni DNI del cliente que se quiere eliminar
	 * @return El contribuyente eliminado
	 * 		   null si no se elimina porque no se encuentra o tiene
	 * 				veh�culos a su nombre
	 */

	public Contribuyente bajaContribuyente(String dni) {
		if(contribuyentes.datosContribuyente(dni) == null)
			return null;
		if(!contribuyentes.datosContribuyente(dni).getListaVehiculos().isEmpty()){
			return null;
		}else{
			Contribuyente cont = contribuyentes.eliminaContribuyente(dni);
			finaliza();
			return cont;
		}
	}

	/**
	 * Retorna el total de impuesto a pagar por un contribuyente
	 * debido a los veh�culos que tiene a su nombre
	 * @param dni DNI del contribuyente buscado
	 * @return El valor a pagar en euros
	 * 			Un valor negativo si el contribuyente no se encuentra
	 */

	public double totalContribuyente(String dni) {

		double result = 0.0;
		Contribuyente c = contribuyentes.datosContribuyente(dni);

		if (c!=null) {
			for (Vehiculo v:c.getListaVehiculos()) {
				result += v.calculaPrecio();
			}
		}else{
			return -1.0;
		}
		return result;
	}

	/**
	 * Retorna el contribuyente cuyo dni se pasa como par�metro
	 * @param dni DNI del contribuyente buscado
	 * @return El contribuyente cuyo dni coincide con el par�metro
	 * 			null en caso de que no se encuentre
	 */

	public Contribuyente contribuyente(String dni) {
		return contribuyentes.datosContribuyente(dni);
	}


	public Vehiculo altaVehiculo(Vehiculo v, Contribuyente c) {
		Contribuyente cont = contribuyentes.datosContribuyente(c.getDni());
		if(cont == null)
			return null;

		Vehiculo veh =vehiculos.vehiculo(v.getMatricula());
		if(veh != null)
			return null;

		Vehiculo vehiculo = vehiculos.creaVehiculo(v, c.getDni());

		finaliza();
		return vehiculo;

	}


	public Vehiculo bajaVehiculo(String matricula, Contribuyente contribuyente) {


		Vehiculo vehiculo = vehiculos.vehiculo(matricula);
		if(vehiculo == null)
			return null;
		Contribuyente cont = contribuyentes.datosContribuyente(contribuyente.getDni());
		if(cont == null)
			return null;

		
			for (Vehiculo v:cont.getListaVehiculos()) {
				if (v.getMatricula().equals(matricula)) {
					Vehiculo veh = vehiculos.eliminaVehiculo(matricula);
					if(veh == null)
						return null;


					finaliza();
					return v;
				}
			}
		return null;
	}


	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}



	public void finaliza() {
		contribuyentes.finaliza();
		vehiculos.finaliza();
	}

	public Contribuyente actualizaContribuyente(Contribuyente c) {
		Contribuyente cont = contribuyentes.datosContribuyente(c.getDni());
		if(cont==null)
			return null;
		finaliza();
		return contribuyentes.actualizaContribuyente(c);
	}	

	public List<Contribuyente>contribuyentes(){
		return contribuyentes.contribuyentes();
	}

	public Vehiculo actualizaVehiculo(Vehiculo v) {
		Vehiculo veh = vehiculos.vehiculo(v.getMatricula());
		if(veh==null)
			return null;
		finaliza();
		return vehiculos.actualizaVehiculo(v);
	}
	public List<Vehiculo>vehiculos(){
		return vehiculos.vehiculos();
	}

	
}

