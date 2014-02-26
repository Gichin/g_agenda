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
	public void ProbarConstructorParametrotest() throws IOException
	{	
		new LeerFicheroConfig("a");		
	}
	@Test ()
	public void ProbarConstructorParametrotestExcepcion() throws IOException
	{	
		new LeerFicheroConfig("config.txt");		
	}
		
	@Test ()
	public void ProbarConstructorParametrotestExcepcionLista() throws IOException
	{	
		
		LeerFicheroConfig Lee =new LeerFicheroConfig("config.txt");
		List <String> Lista = Lee.getLista();
		System.out.println(Lista);
	}
	@Test ()
	
	public void ProbarExcepcionLista() throws IOException
	{	
		LeerFicheroConfig Lee =new LeerFicheroConfig("config.txt");
		System.out.println(Lee.getAny());
		System.out.println(Lee.getIdiomaE());

	}
}
