package Testing;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import es.unican.ps.impuestoCirculacion.businessLayer.GestionImpuestoCirculacion;
import es.unican.ps.impuestoCirculacion.daoLayer.IContribuyentesDAO;
import es.unican.ps.impuestoCirculacion.daoLayer.IVehiculosDAO;
import es.unican.ps.impuestoCirculacion.daoLayer.ImpuestosDAO;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Motocicleta;
import es.unican.ps.impuestoCirculacion.domain.Turismo;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

public class PruebasUnitariasMetodos {

	private static IContribuyentesDAO contribuyentes = mock(IContribuyentesDAO.class);
	private static IVehiculosDAO vehiculos = mock(IVehiculosDAO.class);
	private static GestionImpuestoCirculacion gestion = new GestionImpuestoCirculacion(contribuyentes, vehiculos);


	private static Contribuyente u3aContribuyente, u3bContribuyente, u4aContribuyente, u4bContribuyente,u4cContribuyente,
	u7aContribuyente, u7bContribuyente,u7cContribuyente, u8aContribuyente, u8bContribuyente,u8cContribuyente, u8dContribuyente, 
	u5aContribuyente, u5bContribuyente, u6aContribuyente, u6bContribuyente, u6cContribuyente, u10aContribuyente, u10bContribuyente,
	u11bContribuyente,u11c1Contribuyente, u11c2Contribuyente, u11c3Contribuyente;
	private static Vehiculo u7aVehiculo, u7bVehiculo, u7cVehiculo, u8aVehiculo, u8bVehiculo, u8cVehiculo, u8dVehiculo, u9aVehiculo,
	u9bVehiculo, u12aVehiculo, u12bVehiculo, u13bVehiculo, u13c1Vehiculo, u13c2Vehiculo, u13c3Vehiculo;

	private static List<Contribuyente> u11aContribuyentes, u11bContribuyentes, u11cContribuyentes;
	private static List<Vehiculo> u13aVehiculos, u13bVehiculos, u13cVehiculos;


	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void init(){

		//		Contribuyentes
		u3aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72081145Z");
		u3bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");

		u4aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72081145Z");
		u4bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");
		u4cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72177733S");

		u5aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "78934831M");
		u5bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");

		List<Vehiculo> list = new ArrayList<Vehiculo>();
		list.add(new Turismo("3456HDP", new Date(), 17));
		list.add(new Motocicleta(700, "1234BBB", new Date()));
		u6aContribuyente = new Contribuyente(list, "Lidia", "Lopez", "Revuelta", "78934831M");
		u6bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "78934835M");
		u6cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72081145Z");

		u7aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72345121A");
		u7bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72355121A");
		u7cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "71345631P");




		//		Vehiculos
		u7aVehiculo = new Turismo("2020AAA", new Date(2003, 10, 10), 20);
		u7bVehiculo = new Turismo("2021AAA", new Date(2003, 10, 10), 20);
		u7cVehiculo = new Turismo("2020AAA", new Date(2003, 10, 10), 20);

		u8aVehiculo = new Turismo("2020AAA", new Date(), 20);
		u8bVehiculo = new Turismo("2220AAA", new Date(), 20);
		u8cVehiculo = new Turismo("2020AAA", new Date(), 20);
		u8dVehiculo = new Turismo("1237HDT", new Date(), 20);

		u9aVehiculo = new Turismo("9424BGD", new Date(), 20);
		u9bVehiculo = new Turismo("9424GGD", new Date(), 20);
		
		u12aVehiculo = new Turismo("9424BGD", new Date(2014, 05, 05), 20);
		u12bVehiculo = new Turismo("9424GGD", new Date(2011, 05, 05), 20);
		
		u13bVehiculo = new Turismo("1237HDT", new Date(), 20);
		u13c1Vehiculo = new Turismo("1237HDT", new Date(), 20);
		u13c2Vehiculo = new Turismo("1237HDT", new Date(), 20);
		u13c3Vehiculo = new Turismo("1237HDT", new Date(), 20);


		List<Vehiculo> listu8 = new ArrayList<Vehiculo>();
		listu8.add(u8aVehiculo);
		u8aContribuyente = new Contribuyente(listu8, "Lidia", "Lopez", "Revuelta", "72345121A");
		u8bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72345121A");
		u8cContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72215121A");
		u8dContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "78493121S");

		u10aContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Lopez", "78934831M");
		u10bContribuyente =  new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Lopez", "78935831M");

		u11bContribuyente = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Lopez", "78934831M");
		u11c1Contribuyente =  new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Lopez", "78935831M");
		u11c2Contribuyente =  new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Lopez", "78935831M");
		u11c3Contribuyente =  new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Lopez", "78935831M");

		//Lista de contribuyentes vacía, con 1 y con varios

		u11aContribuyentes = new ArrayList<Contribuyente>();
		u11bContribuyentes = new ArrayList<Contribuyente>();
		u11bContribuyentes.add(u11bContribuyente);
		u11cContribuyentes = new ArrayList<Contribuyente>();
		u11cContribuyentes.add(u11c1Contribuyente);
		u11cContribuyentes.add(u11c2Contribuyente);
		u11cContribuyentes.add(u11c3Contribuyente);
		
		//Lista de vehiculos vacía, con 1 y con varios
		
		u13aVehiculos = new ArrayList<Vehiculo>();
		u13bVehiculos = new ArrayList<Vehiculo>();
		u13bVehiculos.add(u13bVehiculo);
		u13cVehiculos = new ArrayList<Vehiculo>();
		u13cVehiculos.add(u13c1Vehiculo);
		u13cVehiculos.add(u13c2Vehiculo);
		u13cVehiculos.add(u13c3Vehiculo);



	}



	/**
	 * u3.a Contribuyente â€œLidia LÃ³pez Revuelta 72081145Zâ€� intenta darse de alta -> se da de alta correctamente
	 */
	@Test
	public void u3a(){
		when(contribuyentes.nuevoContribuyente(u3aContribuyente)).thenReturn(u3aContribuyente); // Caso u3a

		Contribuyente cOutput;
		cOutput = gestion.altaContribuyente(u3aContribuyente);
		assertTrue(cOutput.equals(u3aContribuyente));

	}

	/**
	 * u3.b Contribuyente â€œVÃ­ctor GÃ³mez Cobo 72189333Sâ€� intenta darse de alta -> se da un error porque ya existe 
	 */
	@Test
	public void u3b(){
		when(contribuyentes.nuevoContribuyente(u3bContribuyente)).thenReturn(null); //Caso u3b

		Contribuyente cOutput;
		cOutput = gestion.altaContribuyente(u3bContribuyente);
		assertTrue(cOutput == (null));
	}

	/**
	 * u4.a Contribuyente â€œ72081145Zâ€� intenta darse de baja -> se da de baja correctamente  
	 */
	@Test
	public void u4a(){
		when(contribuyentes.eliminaContribuyente(u4aContribuyente.getDni())).thenReturn(u4aContribuyente); //Caso u4a

		Contribuyente cOutput;
		cOutput = gestion.bajaContribuyente(u4aContribuyente.getDni());
		assertTrue(cOutput.equals(u4aContribuyente));
	}

	/**
	 * u4.b Contribuyente â€œ72189333Sâ€� intenta darse de baja -> se da un error porque tiene vehÃ­culos asociados 
	 */
	@Test
	public void u4b(){
		when(contribuyentes.eliminaContribuyente(u4bContribuyente.getDni())).thenReturn(null); //Caso u4a

		Contribuyente cOutput;
		cOutput = gestion.bajaContribuyente(u4bContribuyente.getDni());
		assertTrue(cOutput == (null));
	}

	/**
	 * u4.c Contribuyente â€œ72177733Sâ€� intenta darse de baja -> se da un error porque no existe  AS3
	 */
	@Test
	public void u4c(){
		when(contribuyentes.eliminaContribuyente(u4cContribuyente.getDni())).thenReturn(null); //Caso u4c

		Contribuyente cOutput;
		cOutput = gestion.bajaContribuyente(u4cContribuyente.getDni());
		assertTrue(cOutput == (null));
	}



	/**
	 * u5.a Contribuyente â€œ78934831Mâ€� intenta consultarse -> el sistema muestra los datos correctamente porque el contribuyente existe   
	 */
	@Test
	public void u5a(){
		when(contribuyentes.datosContribuyente(u5aContribuyente.getDni())).thenReturn(u5aContribuyente); // Caso u5a

		Contribuyente cOutput;
		cOutput = gestion.contribuyente(u5aContribuyente.getDni());


		assertTrue(cOutput.equals(u5aContribuyente));
	}

	/**
	 * u5.b Contribuyente â€œ78955831Mâ€� intenta consultarse -> se da un error porque el contribuyente no existe 
	 */
	@Test
	public void u5b(){
		when(contribuyentes.datosContribuyente(u5bContribuyente.getDni())).thenReturn(null); // Caso u5b

		Contribuyente cOutput;
		cOutput = gestion.contribuyente(u5bContribuyente.getDni());
		assertTrue(cOutput == (null));
	}

	/**
	 * U6.a Se intenta consultar el total del contribuyente con DNI â€œ78934831Mâ€� -> como el contribuyente existe, retorna 239.8.
	 */
	@Test
	public void u6a(){
		when(contribuyentes.datosContribuyente(u6aContribuyente.getDni())).thenReturn(u6aContribuyente); // Caso u6a

		Double cOutput;
		cOutput = gestion.totalContribuyente(u6aContribuyente.getDni());


		assertTrue(cOutput.equals(239.8));
	}

	/**
	 * U6.b Se intenta consultar el total del contribuyente con DNI â€œ78934835Mâ€� -> como no existe, retorna un valor que indique fallo.
	 */
	@Test
	public void u6b(){
		when(contribuyentes.datosContribuyente(u6bContribuyente.getDni())).thenReturn(null); // Caso u6b

		Double cOutput;
		cOutput = gestion.totalContribuyente(u6bContribuyente.getDni());
		assertTrue(cOutput < 0.0);

	}


	/**
	 * U6.c Se intenta consultar el total de un contribuyente con DNI â€œ72081145Zâ€�, que no tiene vehiÌ�culos -> retorna 0.
	 */
	@Test
	public void u6c(){
		when(contribuyentes.datosContribuyente(u6cContribuyente.getDni())).thenReturn(u6cContribuyente); // Caso u6a

		Double cOutput;
		cOutput = gestion.totalContribuyente(u6cContribuyente.getDni());


		assertTrue(cOutput.equals(0.0));
	}


	/**
	 * u7.a VehÃ­culo â€œ2020AAA 10/10/2003 para el usuario con DNI 72345121Aâ€� intenta darse de alta -> se da de alta correctamente 
	 */
	@Test
	public void u7a(){
		when(vehiculos.creaVehiculo(u7aVehiculo)).thenReturn(u7aVehiculo); // Caso u6a
		when(contribuyentes.datosContribuyente(u7aContribuyente.getDni())).thenReturn(u7aContribuyente); // Caso u6a

		Vehiculo vOutput;
		vOutput = gestion.altaVehiculo(u7aVehiculo, u7aContribuyente);
		assertTrue(vOutput.equals(u7aVehiculo));
	}

	/**
	 * u7.b VehÃ­culo â€œ2021AAA 10/10/2003 para el usuario con DNI 72355121Aâ€� intenta darse de alta -> se da un error porque no existe el contribuyente  
	 */
	@Test
	public void u7b(){
		when(contribuyentes.datosContribuyente(u7bContribuyente.getDni())).thenReturn(null); 

		Vehiculo vOutput;
		vOutput = gestion.altaVehiculo(u7bVehiculo, u7bContribuyente);
		assertTrue(vOutput == (null));	
	}

	/**
	 * u7.c VehÃ­culo â€œ2020AAA 10/10/2003 para el usuario con DNI 71345631Pâ€� intenta darse de alta -> se da un error porque ya existe el vehÃ­culo 
	 */
	@Test
	public void u7c(){
		when(vehiculos.vehiculo(u7cVehiculo.getMatricula())).thenReturn(null); 
		when(contribuyentes.datosContribuyente(u7cContribuyente.getDni())).thenReturn(u7cContribuyente);

		Vehiculo vOutput;
		vOutput = gestion.altaVehiculo(u7cVehiculo, u7cContribuyente);
		assertTrue(vOutput == (null));	
	}


	/**
	 * u8.a VehÃ­culo â€œ2020AAA para el usuario con DNI 72345121Aâ€� intenta darse de baja -> se da de baja correctamente 
	 */
	@Test
	public void u8a(){
		when(vehiculos.eliminaVehiculo(u8aVehiculo.getMatricula())).thenReturn(u8aVehiculo); 
		when(contribuyentes.actualizaContribuyente(u8aContribuyente)).thenReturn(u8aContribuyente);


		Vehiculo vOutput;
		vOutput = gestion.bajaVehiculo(u8aVehiculo.getMatricula(), u8aContribuyente);
		assertTrue(vOutput.equals(u8aVehiculo));
	}

	/**
	 * u8.b VehÃ­culo â€œ2220AAA para el usuario con DNI 72345121Aâ€� intenta darse de baja -> se da un error porque no existe el vehÃ­culo 
	 */
	@Test
	public void u8b(){
		when(vehiculos.eliminaVehiculo(u8bVehiculo.getMatricula())).thenReturn(null); 
		when(contribuyentes.actualizaContribuyente(u8aContribuyente)).thenReturn(u8aContribuyente);


		Vehiculo vOutput;
		vOutput = gestion.bajaVehiculo(u8bVehiculo.getMatricula(), u8bContribuyente);
		assertTrue(vOutput == (null));	
	}

	/**
	 * u8.c VehÃ­culo â€œ2020AAA para el usuario con DNI 72215121Aâ€� intenta darse de baja -> se da un error porque no existe el contribuyente
	 */
	@Test
	public void u8c(){
		when(vehiculos.eliminaVehiculo(u8cVehiculo.getMatricula())).thenReturn(u8cVehiculo); 
		when(contribuyentes.actualizaContribuyente(u8cContribuyente)).thenReturn(null);

		Vehiculo vOutput;
		vOutput = gestion.bajaVehiculo(u8cVehiculo.getMatricula(), u8cContribuyente);
		assertTrue(vOutput == (null));	
	}

	/**
	 * u8.d VehÃ­culo â€œ1237HDT para el usuario con DNI 78493121Sâ€� intenta darse de baja -> se da un error porque el vehÃ­culo no pertenece al contribuyente 
	 */
	@Test
	public void u8d(){
		when(vehiculos.eliminaVehiculo(u8dVehiculo.getMatricula())).thenReturn(u8dVehiculo); 
		when(contribuyentes.actualizaContribuyente(u8dContribuyente)).thenReturn(u8dContribuyente);


		Vehiculo vOutput;
		vOutput = gestion.bajaVehiculo(u8dVehiculo.getMatricula(), u8dContribuyente);
		assertTrue(vOutput == (null));	
	}

	/**
	 * U9.a VehiÌ�culo â€œ9424BGDâ€� intenta consultarse -> el sistema muestra los datos correctamente porque el vehiÌ�culo existe
	 */
	@Test
	public void u9a(){
		when(vehiculos.vehiculo(u9aVehiculo.getMatricula())).thenReturn(u9aVehiculo); 


		Vehiculo vOutput;
		vOutput = gestion.vehiculo(u9aVehiculo.getMatricula());
		assertTrue(vOutput.equals(u9aVehiculo));	
	}


	/**
	 * U9.b VehiÌ�culo â€œ9424GGDâ€� intenta consultarse -> se da un error porque el vehiÌ�culo no existe
	 */
	@Test
	public void u9b(){
		when(vehiculos.vehiculo(u9bVehiculo.getMatricula())).thenReturn(null); 


		Vehiculo vOutput;
		vOutput = gestion.vehiculo(u9bVehiculo.getMatricula());
		assertTrue(vOutput == null);	
	}
	/**
	 * U10.a Intentamos actualizar un contribuyente con DNI “78934831M” cambiándole su segundo
apellido por “López” -> se actualizan los datos correctamente porque el contribuyente existe y
se devuelve el contribuyente actualizado.
	 */
	@Test
	public void u10a(){
		when(contribuyentes.datosContribuyente(u10aContribuyente.getDni())).thenReturn(u10aContribuyente); 
		when(contribuyentes.actualizaContribuyente(u10aContribuyente)).thenReturn(u10aContribuyente);


		Contribuyente vOutput;
		vOutput = gestion.actualizaContribuyente(u10aContribuyente);
		assertTrue(vOutput.equals(u10aContribuyente));
	}
	/**
	 * U10.b Intentamos actualizar un contribuyente con DNI “78935831M” cambiándole su segundo
apellido por “López” -> se indica que ha habido un error porque no existe un contribuyente
con dicho DNI y no se actualiza nada.
	 */
	@Test
	public void u10b(){
		when(contribuyentes.datosContribuyente(u10bContribuyente.getDni())).thenReturn(null); 



		Contribuyente vOutput;
		vOutput = gestion.actualizaContribuyente(u10bContribuyente);
		assertTrue(vOutput == null);	
	}
	/**
	 * U11.a Se intenta consultar el listado de contribuyentes cuando no hay ninguno -> se devuelve una lista vacía
	 */
	@Test
	public void u11a(){
		when(contribuyentes.contribuyentes()).thenReturn(u11aContribuyentes); 


		int vOutput;
		vOutput = gestion.contribuyentes().size();
		assertTrue(vOutput == 0);	
	}
	/**
	 * U11.b Se intenta consultar el listado de contribuyentes cuando sólo hay uno -> se devuelve una lista con un elemento
	 */
	@Test
	public void u11b(){
		when(contribuyentes.contribuyentes()).thenReturn(u11bContribuyentes); 


		int vOutput;
		vOutput = gestion.contribuyentes().size();
		assertTrue(vOutput == 1);	
	}
	/**
	 * U11.c Se intenta consultar el listado de contribuyentes cuando hay varios -> se devuelve una lista con todos los contribuyentes
	 */
	@Test
	public void u11c(){
		when(contribuyentes.contribuyentes()).thenReturn(u11cContribuyentes); 


		int vOutput;
		vOutput = gestion.contribuyentes().size();
		assertTrue(vOutput > 1);	
	}
	/**
	 * U12.a Intentamos actualizar un vehículo con matrícula “9424BGD” cambiándole su fecha de matriculación por “2014-05-05” -> se actualizan los datos correctamente porque el vehículo existe y se devuelve el vehículo actualizado.
	 */
	@Test
	public void u12a(){
		when(vehiculos.actualizaVehiculo(u12aVehiculo)).thenReturn(u12aVehiculo);


		Vehiculo vOutput;
		vOutput = gestion.actualizaVehiculo(u12aVehiculo);
		assertTrue(vOutput.equals(u12aVehiculo));	
	}
	/**
	 * U12.b Intentamos actualizar un vehículo con matrícula “9424GGD” cambiándole su fecha de matriculación por “2011-05-05” -> se indica que ha habido un error porque no existe un vehículo con dicha matrícula y no se actualiza nada.
	 */

	@Test
	public void u12b(){
		when(vehiculos.actualizaVehiculo(u12bVehiculo)).thenReturn(null);


		Vehiculo vOutput;
		vOutput = gestion.actualizaVehiculo(u12bVehiculo);
		assertTrue(vOutput == null);		
	}
	/**
	U13.a Se intenta consultar el listado de vehículos cuando no hay ninguno -> se devuelve una lista vacía	 
	*/
	@Test
	public void u13a(){
		when(vehiculos.vehiculos()).thenReturn(u13aVehiculos); 


		int vOutput;
		vOutput = gestion.vehiculos().size();
		assertTrue(vOutput == 0);	
	}
	/**
	U13.b Se intenta consultar el listado de vehículos cuando sólo hay uno -> se devuelve una lista con un elemento	
	 */
	@Test
	public void u13b(){
		when(vehiculos.vehiculos()).thenReturn(u13bVehiculos); 


		int vOutput;
		vOutput = gestion.vehiculos().size();
		assertTrue(vOutput == 1);	
	}
	/**
	 U13.c Se intenta consultar el listado de vehículos cuando hay varios -> se devuelve una lista con todos los vehículos
	 */
	@Test
	public void u13c(){
		when(vehiculos.vehiculos()).thenReturn(u13cVehiculos); 


		int vOutput;
		vOutput = gestion.vehiculos().size();
		assertTrue(vOutput > 1);	
	}
}
