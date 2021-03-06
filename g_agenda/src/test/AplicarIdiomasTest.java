/**
 * @author Ester Mesa
 *
 */
package test;

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
	
	private List<String> getListaDummyE() {
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
	
	private List<String> getListaDummyS() {
			return Arrays.asList(
					
					"001;Schedule",
					"002;Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday",
					"003;MTWHFSN", 
					"004;January,February,March,April,May,June,July,August,September,October,November,December",
					"005;Year,Month,Week,Day",
					"006;Generated by",
					"007;Closed",
					"008;Error"
			);
	}
	
@Before	public void inicio() 
	{
		
		try {
			SUT = new AplicarIdiomas();
			
			SUT.setIdiomaE(entrada);
			Mockito.doReturn(getListaDummyE()).when(entrada).getLista();
			SUT.Rellenar_Campos_Entrada();	
			
			SUT.setIdiomaS(salida);				
			Mockito.doReturn(getListaDummyS()).when(salida).getLista();
			SUT.Rellenar_Campos_Salida();
				
			Mockito.verify(entrada, Mockito.times(1)).getLista();				
			Mockito.verify(salida, Mockito.times(1)).getLista();					
		} catch (Exception e) {		
			e.printStackTrace();			    
		}
	}
		
	
	@Test (expected=Exception.class)
	public void ProbarConstructorAplicarIdiomasEsperandoExcepcion() throws Exception
	{			
		SUT =new AplicarIdiomas ("", "ENG");		
	}
	
	@Test ()
	public void ProbarConstructorAplicarIdiomas() throws Exception
	{		
		SUT = new AplicarIdiomas ("CAT", "ENG");		
	}
	@Test
	public void Rellenar_Campos_Entrada (){
		SUT.Rellenar_Campos_Entrada ();	
	}
	
	@Test
	public void Rellenar_Campos_Salida (){
		SUT.Rellenar_Campos_Salida ();
	}
	
}
