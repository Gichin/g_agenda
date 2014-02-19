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

import util.AplicarIdiomas;
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
	
	

	@Test ()	
	public void Probar_DiadelaSemana(int dia, int mes, int any, AplicarIdiomas Idioma)  throws Exception  //ESTHER
	{		
		AplicarIdiomas Id = new AplicarIdiomas ("CAT", "ENG");
		
		int d = Utiles.DiadelaSemana(3,2,2008,Id);
		char letra = 0;
		
		//AassertEquals("Ojo", expected, actual);
	}
	

}
