import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.impuestoCirculacion.businessLayer.GestionImpuestoCirculacion;
import es.unican.ps.impuestoCirculacion.daoLayer.IContribuyentesDAO;
import es.unican.ps.impuestoCirculacion.daoLayer.IVehiculosDAO;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Turismo;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

public class AceptacionYSistemaTest {

	private static GestionImpuestoCirculacion gestion = new ;
	private static IContribuyentesDAO contribuyentes =  mock(IContribuyentesDAO.class);
	private static IVehiculosDAO vehiculos =  mock(IVehiculosDAO.class);
	private static Contribuyente as1a, as1b, as4aContribuyente;
	private static Vehiculo as3a, as3b, as3c, as4a, as4b, as4c, as4d, as5a, as5b;

	@Before
	public void beforeMethods(){

	}

	@After
	public void afterMethods(){

	}

	@BeforeClass
	public static void init(){
		//		Gestion
		gestion = new GestionImpuestoCirculacion(contribuyentes, vehiculos );

		//		Contribuyentes
		as1a = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "Lopez", "Revuelta", "72081145Z");
		as1b = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");
		//		Vehiculos
		as4a = new Turismo("", new Date(), 20);

		//		Que hacen los mocks cuando se llama a sus metodos de contribuyentes
		when(contribuyentes.creaContribuyente(as1a)).thenReturn(as1a); // Caso as1a
		when(contribuyentes.creaContribuyente(as1b)).thenReturn(null); //Caso as1b
		
		//		Que hacen los mocks cuando se llama a sus metodos de vehiculos
		when(vehiculos.altaVehiculo(as4a, as4aContribuyente)).thenReturn(as4a);


	}
	@AfterClass
	public static void end(){
	}


	/**
	 * Contribuyente Lidia Lopez Revuelta 72081145Zâ€� intenta darse de alta -> se da de alta correctamente
	 */
	@Test
	public void as1a(){



		Contribuyente cOutput = gestion.altaContribuyente(as1a);

		assertTrue(cOutput != null);

	}

	/**
	 * AS1.b Contribuyente “Víctor Gómez Cobo 72189333S” intenta darse de alta -> se da un error
porque ya existe
	 */
	@Test
	public void as1b(){

		Contribuyente cInput = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");
		Contribuyente cOutput = gestion.altaContribuyente(cInput);

		assertTrue(cOutput == null);

	}

	@Test
	public void as3a(){

		Contribuyente cInput = new Contribuyente(new ArrayList<Vehiculo>(), "Victor", "Gomez", "Cobo", "72189333S");
		Contribuyente cOutput = gestion.altaContribuyente(cInput);

		assertTrue(cOutput == null);

	}
}
