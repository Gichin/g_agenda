package test;

/**
 * @author Ester Mesa
 *
 */
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import negocio.LeerFicheroConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.AplicarIdiomas;
import util.LeerFichero;
import util.Utiles;


public class UtilesTest {

	@Test (expected=Exception.class)
	public void testHoras_Array() throws Exception  {			
		Utiles.Horas_Array(".");		
	}
		
	
	@Test ()
	public void testHoras_Array_Numero() throws Exception
	{	
		int[] Arry = new int[4];	
		int[] Arry2 = Utiles.Horas_Array("08-12");			
		Arry[2]=10;		
		assertEquals (Arry2[2], Arry[2], 0);
	}
	
	@Test ()
	public void testHoras_Array_Numero_Dos_Intervalos() throws Exception
	{	
		int[] Arry = new int[8];	
		int[] Arry2 = Utiles.Horas_Array("08-11_15-20");			
		Arry[6]=18;		
		assertEquals (Arry2[6], Arry[6], 0);
	}
	
	

	@Test (expected=Exception.class)	
	public void Probar_DiadelaSemana()  throws Exception  //ESTHER
	{		
		AplicarIdiomas Id = new AplicarIdiomas ("CAT","");			
		assertEquals (Utiles.DiadelaSemana(20, 2, 2014, Id), 'J', 0);
	}
	
	@Test ()	
	public void Probar_DiadelaSemana_OK()  throws Exception  //ESTHER
	{		
		AplicarIdiomas Id = new AplicarIdiomas ("CAT","ENG");				
		assertEquals (Utiles.DiadelaSemana(20, 2, 2014, Id), 'J', 0);
	}
	
	
}
