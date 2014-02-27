package test;

import static org.junit.Assert.*; 
import java.io.IOException;
import java.util.List;

import negocio.LeerFicheroConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import util.LeerFichero;
/**
 * @author Ester Mesa
 *
 */

@RunWith(MockitoJUnitRunner.class)

public class LeerFicheroConfigTest {
	
	private LeerFicheroConfig SUT;

	@Mock
	private LeerFichero util;
	
	@Before
	public void inicio() {
		try {
			SUT = new LeerFicheroConfig("config.txt");
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}	

	@Test (expected=IOException.class)
	public void ProbarConstructorParametroError() throws IOException
	{	
		new LeerFicheroConfig("a");		
	}
	@Test ()
	public void ProbarConstructorParametroOK() throws IOException
	{	
		new LeerFicheroConfig("config.txt");		
	}
		
	@Test ()
	public void ProbarLista() throws IOException
	{			
		List <String> Lista = SUT.getLista();
	}
	@Test ()
	
	public void ProbarCamposDeLista() throws IOException
	{	
		assertEquals(SUT.getAny(),2008, 0);
		assertEquals(SUT.getMes(),11, 0);		
	}
}
