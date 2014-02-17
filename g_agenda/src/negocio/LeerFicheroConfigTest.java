package negocio;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.LeerFichero;

public class LeerFicheroConfigTest {


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
