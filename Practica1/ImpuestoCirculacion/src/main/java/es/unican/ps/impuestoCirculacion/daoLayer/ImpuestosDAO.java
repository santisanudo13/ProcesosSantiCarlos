package es.unican.ps.impuestoCirculacion.daoLayer;

import java.util.LinkedList;
import java.util.List;


import es.unican.ps.impuestoCirculacion.domain.Ayuntamiento;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;




public class ImpuestosDAO implements IContribuyentesDAO, IVehiculosDAO {

	private Ayuntamiento ayun;

	public ImpuestosDAO() {
		ayun = Ayuntamiento.creaAyuntamiento();
	}


	public Contribuyente nuevoContribuyente(Contribuyente c) {
		ayun.getContribuyentes().add(c);
		return c;
	}


	public Contribuyente datosContribuyente(String dni) {
		for (Contribuyente c: ayun.getContribuyentes()) {
			if (c.getDni().equals(dni)) {
				return c;
			}
		}
		return null;
	}


	public Contribuyente actualizaContribuyente(Contribuyente nuevo) {
		for (Contribuyente cont: ayun.getContribuyentes()) {
			if (cont.getDni().equals(nuevo.getDni())) {
				ayun.getContribuyentes().remove(cont);
				ayun.getContribuyentes().add(nuevo);
				return nuevo;
			}
		}
		return null;
	}


	public Contribuyente eliminaContribuyente(String dni) {
		for (Contribuyente c: ayun.getContribuyentes()) {
			if (c.getDni().equals(dni)) {
				ayun.getContribuyentes().remove(c);
				return c;
			}
		}
		return null;
	}


	public List<Contribuyente> contribuyentes() {
		return ayun.getContribuyentes();
	}


	public Vehiculo creaVehiculo(Vehiculo v, String dni) {
		Contribuyente c = datosContribuyente(dni);
		if(c == null)
			return null;

		for(Vehiculo vehiculo: c.getListaVehiculos()){
			if(v.getMatricula().equals(vehiculo.getMatricula())){
				return null;
			}
		}
		c.getListaVehiculos().add(v);
		return v;
	}


	public Vehiculo eliminaVehiculo(String matricula) {


		Vehiculo veh = null;
		for(Contribuyente c: contribuyentes())
			for(Vehiculo v: c.getListaVehiculos()){
				if(v.getMatricula().equals(matricula)){
					veh = v;
					c.getListaVehiculos().remove(v);
					break;
				}
			}
		return veh;
	}


	public Vehiculo actualizaVehiculo(Vehiculo nuevo) {
		for(Contribuyente c: contribuyentes())
			for(Vehiculo v: c.getListaVehiculos()){
				if(v.getMatricula().equals(nuevo.getMatricula())){
					v = nuevo;
					return v;
				}
			}
		return null;
	}


	public Vehiculo vehiculo(String matricula) {
		for (Vehiculo v: vehiculos()) {
			if (v.getMatricula().equals(matricula)) {
				return v;
			}
		}

		return null;
	}


	public List<Vehiculo> vehiculos() {
		List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		for (Contribuyente c: contribuyentes()) {
			vehiculos.addAll(c.getListaVehiculos());
		}
		return vehiculos;
	}


	public void finaliza() {
		Ayuntamiento.flush(ayun);
	}







}
