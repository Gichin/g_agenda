/**
 * @author Ester Mesa
 *
 */
package test;
/*
import static org.junit.Assert.*; 
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.util.List;
*/
//import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

import util.LeerFichero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import util.AplicarIdiomas;

@RunWith(MockitoJUnitRunner.class)


public class AplicarIdiomasTest 
{
	private AplicarIdiomas SUT;

	@Mock
	private LeerFichero entrada;

	@Mock
	private LeerFichero salida;
	
	private List<String> getListaDummy() {
		return Arrays.asList(
				"001;Agenda", 
				"002;Dilluns,Dimarts,Dimecres,Dijous,Divendres,Dissabte,Diumenge",
				"003;LMCJVSG",
				"004;Gener,Febrer,Marc,Abril,Maig,Juny,Juliol,Agost,Setembre,Octubre,Novembre,Desembre",
				"005;Any,Mes,Setmana,Dia",
				"006;Generat per",
				"007;Tancat",
				"008;Error"
		);
	}
	
@Before	public void inicio() 
	{
		
	//LeerFichero util = new LeerFichero("config.txt");
		
		try {
			SUT = new AplicarIdiomas();
			SUT.setIdiomaE(entrada);
			
			Mockito.doReturn(getListaDummy()).when(entrada).getLista();
			
			SUT.Rellenar_Campos_Entrada();
			
			Mockito.verify(entrada, Mockito.times(1)).getLista();		
			
			SUT.setIdiomaS(salida);
			SUT.Rellenar_Campos_Salida();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	//	try {
	//		SUT = new AplicarIdiomas("CAT", "ENG");
	//		} 
	//	catch (Exception e) {	e.printStackTrace();}
	}
	
	
	
	
	
	
	
	@Test (expected=Exception.class)
	public void ProbarConstructorAplicarIdiomas() throws Exception
	{	
				
	//	AplicarIdiomas idioma = new AplicarIdiomas ("", "ENG");	
	//	idioma.Rellenar_Campos_Entrada ();
	//	idioma.Rellenar_Campos_Salida ();
		
		SUT =new AplicarIdiomas ("", "ENG");
		SUT.Rellenar_Campos_Entrada ();
		SUT.Rellenar_Campos_Salida ();
		

	}
	@Test ()
	public void ProbarConstructorAplicarIdiomasExcepcion() throws Exception
	{	
		AplicarIdiomas idioma = new AplicarIdiomas ("CAT", "ENG");		
		idioma.Rellenar_Campos_Entrada ();
		idioma.Rellenar_Campos_Salida ();	
	}
}
