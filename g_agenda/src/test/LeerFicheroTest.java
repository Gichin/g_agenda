/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.LeerFichero;

/**
 * @author Ester Mesa
 *
 */
public class LeerFicheroTest

{
	private LeerFichero SUT;
	
	@Before
	
	public void Inicio (){
		try {
			SUT = new LeerFichero("peticions.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test (expected=IOException.class)
	
	public void ProbarParametroERROR() throws IOException
	{	
		SUT = new LeerFichero("a");		
	}

	@Test ()
	public void ProbarConstructorOK() throws IOException
	{	
		SUT = new LeerFichero("peticions.txt");		
	}
	
	@Test ()
	public void ProbarAccesoLista() throws IOException
	{			
		List <String> Lista = SUT.getLista();
		System.out.println(Lista);
	}
	
}
