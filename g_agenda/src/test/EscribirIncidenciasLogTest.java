package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import negocio.EscribirIncidenciasLog;
import negocio.LeerFicheroConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EscribirIncidenciasLogTest {

	@Test (expected=IOException.class)
	public void ProbarEscribirIncidencia() throws IOException
	{	
		List<String> list =	new ArrayList<String>();
			
			list.add("#Resum Activitats 11/2008"); 	
			
		EscribirIncidenciasLog Incidencias =new EscribirIncidenciasLog (list,"");
	}
	
	
	@Test ()
	
	public void ProbarEscribirIncidencia_() throws Exception 
	{	
		List<String> list =	new ArrayList<String>();
				
		EscribirIncidenciasLog Incidencias =new EscribirIncidenciasLog (list,"incidencias.log");
	}
}
