package Testing;

import java.awt.event.KeyEvent;

import org.fest.swing.core.KeyPressInfo;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.ps.impuestoCirculacion.businessLayer.GestionImpuestoCirculacion;
import es.unican.ps.impuestoCirculacion.daoLayer.ImpuestosDAO;
import es.unican.ps.impuestoCirculacion.presentationLayer.VistaFuncionario;

public class AceptacionYSistemaTest {

	FrameFixture frame;


	@Before
	public  void init(){
		ImpuestosDAO datos = new ImpuestosDAO();
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(datos, datos);
		VistaFuncionario vista = new VistaFuncionario(negocio, negocio);

		frame = new FrameFixture(vista);
		vista.setVisible(true);
	}

	@After
	public void end() {
		frame.cleanUp();
	}





	/**
	 * AS5.a Contribuyente â€œ78934831Mâ€� intenta consultarse -> el sistema muestra los datos correctamente porque el contribuyente existe   
	 */
	@Test
	public void u2a(){
		frame.textBox("dniContribuyente").enterText("78934831M").pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));

		frame.textBox("nombreContribuyente").requireText("Amador Rivas Cobo");
		frame.list("listVehiculos").requireItemCount(2);
		frame.textBox("totalContribuyente").requireText("239.8");

	}

	/**
	 * AS5.b Contribuyente â€œ78955831Mâ€� intenta consultarse -> se da un error porque el contribuyente no existe 
	 */
	@Test
	public void u2b(){
		frame.textBox("dniContribuyente").enterText("78955831M").pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));

		frame.textBox("nombreContribuyente").requireText("DNI No Valido");

	}

}
