package Testing;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import es.unican.ps.impuestoCirculacion.businessLayer.GestionImpuestoCirculacion;
import es.unican.ps.impuestoCirculacion.businessLayer.IGestionContribuyentes;
import es.unican.ps.impuestoCirculacion.businessLayer.IGestionVehiculos;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Turismo;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

public class PruebasUnitariasMetodos {

	private static IGestionContribuyentes gestionContribuyentes = mock(IGestionContribuyentes.class);
	private static IGestionVehiculos gestionVehiculos = mock(IGestionVehiculos.class);


	private static Contribuyente as1aContribuyente, as1bContribuyente, as2aContribuyente, as2bContribuyente,as2cContribuyente,
	as3aContribuyente, as3bContribuyente,as3cContribuyente, as4aContribuyente, as4bContribuyente,as4cContribuyente, as4dContribuyente, 
	as5aContribuyente, as5bContribuyente;
	private static Vehiculo as3aVehiculo, as3bVehiculo, as3cVehiculo, as4aVehiculo, as4bVehiculo, as4cVehiculo, as4dVehiculo;
	

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void init(){

		//		Contribuyentes
		as1aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72081145Z");
		as1bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");

		as2aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72081145Z");
		as2bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");
		as2cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72177733S");

		as3aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72345121A");
		as3bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72355121A");
		as3cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "71345631P");

		as4aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72345121A");
		as4bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72345121A");
		as4cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72215121A");
		as4dContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "78493121S");

		as5aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "78934831M");
		as5bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");

		//		Vehiculos
		as3aVehiculo = new Turismo("2020AAA", new Date(2003, 10, 10), 20);
		as3bVehiculo = new Turismo("2021AAA", new Date(2003, 10, 10), 20);
		as3cVehiculo = new Turismo("2020AAA", new Date(2003, 10, 10), 20);

		as4aVehiculo = new Turismo("2020AAA", new Date(), 20);
		as4bVehiculo = new Turismo("2220AAA", new Date(), 20);
		as4cVehiculo = new Turismo("2020AAA", new Date(), 20);
		as4dVehiculo = new Turismo("1237HDT", new Date(), 20);

		//		AS1
		when(gestionContribuyentes.altaContribuyente(as1aContribuyente)).thenReturn(as1aContribuyente); // Caso as1a
		when(gestionContribuyentes.altaContribuyente(as1bContribuyente)).thenReturn(null); //Caso as1b
		//		AS2
		when(gestionContribuyentes.bajaContribuyente(as2aContribuyente.getDni())).thenReturn(as2aContribuyente); //Caso as2a
		when(gestionContribuyentes.bajaContribuyente(as2bContribuyente.getDni())).thenReturn(null); //Caso as2a
		when(gestionContribuyentes.bajaContribuyente(as2cContribuyente.getDni())).thenReturn(null); //Caso as2c
		//		AS3
		when(gestionVehiculos.altaVehiculo(as3aVehiculo, as3aContribuyente)).thenReturn(as3aVehiculo); //Caso as3a
		when(gestionVehiculos.altaVehiculo(as3bVehiculo, as3bContribuyente)).thenReturn(null); //Caso as3b
		when(gestionVehiculos.altaVehiculo(as3cVehiculo, as3cContribuyente)).thenReturn(null); //Caso as3c
		//		AS4
		when(gestionVehiculos.bajaVehiculo(as4aVehiculo.getMatricula(), as4aContribuyente)).thenReturn(as4aVehiculo); //Caso as4a
		when(gestionVehiculos.bajaVehiculo(as4bVehiculo.getMatricula(), as4bContribuyente)).thenReturn(null); //Caso as4b
		when(gestionVehiculos.bajaVehiculo(as4cVehiculo.getMatricula(), as4cContribuyente)).thenReturn(null); //Caso as4c
		when(gestionVehiculos.bajaVehiculo(as4dVehiculo.getMatricula(), as4dContribuyente)).thenReturn(null); //Caso as4d
		//		AS5
		when(gestionContribuyentes.contribuyente(as5aContribuyente.getDni())).thenReturn(as5aContribuyente); // Caso as5a
		when(gestionContribuyentes.contribuyente(as5bContribuyente.getDni())).thenReturn(null); // Caso as5b
	}



	/**
	 * AS1.a Contribuyente “Lidia López Revuelta 72081145Z” intenta darse de alta -> se da de alta correctamente
	 */
	@Test
	public void as1a(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.altaContribuyente(as1aContribuyente);
		assertTrue(cOutput.equals(as1aContribuyente));

	}

	/**
	 * AS1.b Contribuyente “Víctor Gómez Cobo 72189333S” intenta darse de alta -> se da un error porque ya existe 
	 */
	@Test
	public void as1b(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.altaContribuyente(as1bContribuyente);
		assertTrue(cOutput == (null));
	}

	/**
	 * AS2.a Contribuyente “72081145Z” intenta darse de baja -> se da de baja correctamente  
	 */
	@Test
	public void as2a(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.bajaContribuyente(as2aContribuyente.getDni());
		assertTrue(cOutput.equals(as2aContribuyente));
	}

	/**
	 * AS2.b Contribuyente “72189333S” intenta darse de baja -> se da un error porque tiene vehículos asociados 
	 */
	@Test
	public void as2b(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.bajaContribuyente(as2bContribuyente.getDni());
		assertTrue(cOutput == (null));
	}

	/**
	 * AS2.c Contribuyente “72177733S” intenta darse de baja -> se da un error porque no existe  AS3
	 */
	@Test
	public void as2c(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.bajaContribuyente(as2cContribuyente.getDni());
		assertTrue(cOutput == (null));
	}

	/**
	 * AS3.a Vehículo “2020AAA 10/10/2003 para el usuario con DNI 72345121A” intenta darse de alta -> se da de alta correctamente 
	 */
	@Test
	public void as3a(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.altaVehiculo(as3aVehiculo, as3aContribuyente);
		assertTrue(vOutput.equals(as3aVehiculo));
	}

	/**
	 * AS3.b Vehículo “2021AAA 10/10/2003 para el usuario con DNI 72355121A” intenta darse de alta -> se da un error porque no existe el contribuyente  
	 */
	@Test
	public void as3b(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.altaVehiculo(as3bVehiculo, as3bContribuyente);
		assertTrue(vOutput == (null));	
	}
	
	/**
	 * AS3.c Vehículo “2020AAA 10/10/2003 para el usuario con DNI 71345631P” intenta darse de alta -> se da un error porque ya existe el vehículo 
	 */
	@Test
	public void as3c(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.altaVehiculo(as3cVehiculo, as3cContribuyente);
		assertTrue(vOutput == (null));	
	}
	
	/**
	 * AS4.a Vehículo “2020AAA para el usuario con DNI 72345121A” intenta darse de baja -> se da de baja correctamente 
	 */
	@Test
	public void as4a(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.bajaVehiculo(as4aVehiculo.getMatricula(), as4aContribuyente);
		assertTrue(vOutput.equals(as4aVehiculo));
	}
	
	/**
	 * AS4.b Vehículo “2220AAA para el usuario con DNI 72345121A” intenta darse de baja -> se da un error porque no existe el vehículo 
	 */
	@Test
	public void as4b(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.bajaVehiculo(as4bVehiculo.getMatricula(), as4bContribuyente);
		assertTrue(vOutput == (null));	
	}
	
	/**
	 * AS4.c Vehículo “2020AAA para el usuario con DNI 72215121A” intenta darse de baja -> se da un error porque no existe el contribuyente
	 */
	@Test
	public void as4c(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.bajaVehiculo(as4cVehiculo.getMatricula(), as4cContribuyente);
		assertTrue(vOutput == (null));	
	}
	
	/**
	 * AS4.d Vehículo “1237HDT para el usuario con DNI 78493121S” intenta darse de baja -> se da un error porque el vehículo no pertenece al contribuyente 
	 */
	@Test
	public void as4d(){
		Vehiculo vOutput;
		vOutput = gestionVehiculos.bajaVehiculo(as4dVehiculo.getMatricula(), as4dContribuyente);
		assertTrue(vOutput == (null));	
	}
	
	/**
	 * AS5.a Contribuyente “78934831M” intenta consultarse -> el sistema muestra los datos correctamente porque el contribuyente existe   
	 */
	@Test
	public void as5a(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.contribuyente(as5aContribuyente.getDni());
		assertTrue(cOutput.equals(as5aContribuyente));
	}
	
	/**
	 * AS5.b Contribuyente “78955831M” intenta consultarse -> se da un error porque el contribuyente no existe 
	 */
	@Test
	public void as5b(){
		Contribuyente cOutput;
		cOutput = gestionContribuyentes.contribuyente(as5bContribuyente.getDni());
		assertTrue(cOutput == (null));
	}





	
}
