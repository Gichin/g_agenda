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

	@Test (expected=IOException.class)
	public void ProbarConstructorParametrotest() throws IOException
	{	
		new LeerFichero("a");		
	}

	@Test ()
	public void ProbarConstructorParametrotestExcepcion() throws IOException
	{	
		new LeerFichero("peticions.txt");		
	}
	
	@Test ()
	public void ProbarConstructorParametrotestExcepcionLista() throws IOException
	{			
		LeerFichero Lee =new LeerFichero("peticions.txt");
		List <String> Lista = Lee.getLista();
		System.out.println(Lista);
	}
	
}
