package es.unican.ps.impuestoCirculacion.businessLayer;

import es.unican.ps.common.ILifecycle;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;


public interface IGestionContribuyentes extends ILifecycle {
	
	/**
	 * A�ade un nuevo contribuyente al sistema.
	 * @param c Contribuyente que se a�ade
	 * @return El contribuyente a�adido
	 * 		   null si no se a�ade porque ya existe
	 */
	public Contribuyente altaContribuyente(Contribuyente c);
	
	/**
	 * Elimina el contribuyente cuyo dni se pasas como par�metro
	 * del sistema.
	 * @param dni DNI del cliente que se quiere eliminar
	 * @return El contribuyente eliminado
	 * 		   null si no se elimina porque no se encuentra o tiene
	 * 				veh�culos a su nombre
	 */
	public Contribuyente bajaContribuyente(String dni);
	
	/**
	 * Retorna el contribuyente cuyo dni se pasa como par�metro
	 * @param dni DNI del contribuyente buscado
	 * @return El contribuyente cuyo dni coincide con el par�metro
	 * 			null en caso de que no se encuentre
	 */
	public Contribuyente contribuyente(String dni); 
	
	/**
	 * Retorna el total de impuesto a pagar por un contribuyente
	 * debido a los veh�culos que tiene a su nombre
	 * @param dni DNI del contribuyente buscado
	 * @return El valor a pagar en euros
	 * 			Un valor negativo si el contribuyente no se encuentra
	 */
	public double totalContribuyente(String dni);

}
