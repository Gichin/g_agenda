package test;

import static org.junit.Assert.*; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import negocio.EscribirIncidenciasLog;
import negocio.LeerFicheroConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Utiles;

public class EscribirIncidenciasLogTest {
	
	List<String> list =	new ArrayList<String>();
	List<String> rlist =	new ArrayList<String>();
	
	EscribirIncidenciasLog Incidencias;
		

	@Before
	public void Inicio() {
		try {
			  Incidencias =new EscribirIncidenciasLog (list,"incidencias.log",11,2008);
			} catch (Exception e) {		
			e.printStackTrace();			    
		}
	}
	
	@Test
	public void ProbarLista (){
		
		list.add("ReunioPerl Sala1 01/09/2008 31/12/2008 LMJ 14-15_17-18 ReunioPerl 3 17 6 L");
		rlist = Incidencias.TratarLista(list);	
		
		assertEquals(rlist.equals(list), false);

	}
	
	
	@Test (expected = java.lang.Exception.class)
	
	public void ProbarEscribirIncidencia() throws Exception
	{	
		Incidencias =new EscribirIncidenciasLog (list,"",11,2008);
	}
		
	@Test ()
	
	public void ProbarEscribirIncidenciaBIS() throws Exception 
	{	
		 list =	new ArrayList<String>();
	}
}
