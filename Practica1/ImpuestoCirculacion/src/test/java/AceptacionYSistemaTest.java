import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.impuestoCirculacion.businessLayer.GestionImpuestoCirculacion;
import es.unican.ps.impuestoCirculacion.daoLayer.ImpuestosDAO;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

public class AceptacionYSistemaTest {
	
	private static GestionImpuestoCirculacion gestion;
	@Before
	public void beforeMethods(){
		
	}
	
	@After
	public void afterMethods(){
		
	}
	
	@BeforeClass
	public static void init(){
		gestion = new GestionImpuestoCirculacion(new ImpuestosDAO(), new ImpuestosDAO());
	}
	
	
	/**
	 * Contribuyente “Lidia López Revuelta 72081145Z” intenta darse de alta -> se da de alta correctamente
	 */
	@Test
	public void as1a(){
		
		Contribuyente cInput = new Contribuyente(new ArrayList<Vehiculo>(), "Lidia", "López", "Revuelta", "72081145Z");
		Contribuyente cOutput = gestion.altaContribuyente(cInput);
		
		assertTrue(cOutput != null);
		
	}

}
