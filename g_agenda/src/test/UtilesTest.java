package test;

/**
 * @author Ester Mesa
 *
 */
import static org.junit.Assert.*;  

import java.io.IOException;

import negocio.LeerFicheroConfig;

import org.junit.Before;
import org.junit.Test;

import util.AplicarIdiomas;
import util.LeerFichero;
import util.Utiles;


public class UtilesTest {
	
	private Utiles SUT ;
	private AplicarIdiomas Id;
	private LeerFicheroConfig conf;
	
	@Before	
	public void Inicio (){
		try {
			SUT = new Utiles();
			conf = new LeerFicheroConfig ("config.txt");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test (expected=Exception.class)
	public void testHoras_Array() throws Exception  {			
		SUT.Horas_Array(".");		
	}
			
	@Test ()
	public void testHoras_Array_Numero() throws Exception
	{	
		int[] Arry = new int[4];	
		int[] Arry2 = SUT.Horas_Array("08-12");			
		Arry[2]=10;		
		assertEquals (Arry2[2], Arry[2], 0);
	}
	
	@Test ()
	public void testHoras_Array_Numero_Dos_Intervalos() throws Exception
	{	
		int[] Arry = new int[8];	
		int[] Arry2 = SUT.Horas_Array("08-11_15-20");			
		Arry[6]=18;		
		assertEquals (Arry2[6], Arry[6], 0);
	}
	

	@Test (expected=Exception.class)	
	public void Probar_DiadelaSemana_Error()  throws Exception  //ESTHER
	{		
		Id = new AplicarIdiomas ("CAT","");			
		assertEquals (SUT.DiadelaSemana(20, 2, 2014, Id), 'J', 0);
	}
	
	@Test ()	
	public void Probar_DiadelaSemana_OK()  throws Exception  //ESTHER
	{		
		Id = new AplicarIdiomas ("CAT","ENG");				
		assertEquals (SUT.DiadelaSemana(20, 2, 2014, Id), 'J', 0);
	}
	
	@Test
	public void Probar_Mes_OK() {
		
		try {
			SUT.Mes_de_Salida(conf);
			assertEquals ((String)SUT.Mes_de_Salida(conf),"November");
			} catch (Exception e) {			
			e.printStackTrace();
		}			
	}
	
	@Test ()
	public void Probar_Mes_ERROR()  {		
		try {
			SUT.Mes_de_Salida(conf);
			assertEquals (SUT.Mes_de_Salida(conf).equals("December"),false);			
		} catch (Exception e) {
		
			e.printStackTrace();
		}		
	}		
}
