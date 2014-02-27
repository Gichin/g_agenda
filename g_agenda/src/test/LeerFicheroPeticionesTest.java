package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import util.AplicarIdiomas;
import util.LeerFichero;
import negocio.LeerFicheroPeticiones;



public class LeerFicheroPeticionesTest {

	private LeerFicheroPeticiones SUT;

	//Emula la lectuira del fichero de Peticiones
	private List<String> getListaDummy() {
		return Arrays.asList(
				"Tancat Sala1 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24", 
				"Tancat Sala1 01/01/2008 31/12/2008 G 00-24",
				"ReunioPerl Sala1 01/05/2008 31/12/2008 LMJ 12-13_17-18",
				"ReunioJavaMediodia Sala1 25/09/2008 02/12/2008 LMCJV 12-14",
				"ReunioJavaMañana Sala1 25/09/2008 02/12/2008 LMCJV 08-10"
		);
	}
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
		SUT = new LeerFicheroPeticiones("c:\\documentos\\peticions.txt", 2008, 11, "CAT", "CAT");
	}

	@After
	public void tearDown() throws Exception {
		SUT = null;
		
	}

	

	@Test
	public final void testGetLog() {
		
		List<String> list = new ArrayList();
		list = SUT.getLog();
		assertEquals (list.isEmpty(), false);
	}

	@Test
	public final void testLineaLog() {
		String linea;
		linea = SUT.getLog().get(1);
		
		assertEquals (linea.equals("# Resum Activitats :	0/0"), true);
	}
	
	
	@Test
	public final void testGetEstructura() {
		fail("Not yet implemented"); // TODO
		
				
	}

	@Test
	public final void testLeerFicheroPeticiones() {
		fail("Not yet implemented"); // TODO
	}

}
