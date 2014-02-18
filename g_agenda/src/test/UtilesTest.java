package test;

/**
 * @author Ester Mesa
 *
 */
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import negocio.LeerFicheroConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.LeerFichero;
import util.Utiles;

public class UtilesTest {

	@Test (expected=Exception.class)
	public void testHoras_Array() throws Exception  {			
		Utiles.Horas_Array(".");		
	}
	
	@Test (expected=Exception.class)
	public void testHoras_Array_Numero() throws Exception
	{	
		Utiles.Horas_Array("12,14");		
	}
	

}
