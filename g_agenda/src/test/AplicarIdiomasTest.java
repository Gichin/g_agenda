package test;

import static org.junit.Assert.*;

import java.io.IOException;

import negocio.LeerFicheroConfig;

import org.junit.Test;

import util.AplicarIdiomas;

public class AplicarIdiomasTest {


	@Test (expected=Exception.class)
	public void ProbarConstructorAplicarIdiomas() throws Exception
	{	
		AplicarIdiomas idioma = new AplicarIdiomas ("", "ENG");		
		idioma.Rellenar_Campos_Entrada ();
		idioma.Rellenar_Campos_Salida ();
	}
	@Test ()
	public void ProbarConstructorAplicarIdiomasExcepcion() throws Exception
	{	
		AplicarIdiomas idioma = new AplicarIdiomas ("CAT", "ENG");		
		idioma.Rellenar_Campos_Entrada ();
		idioma.Rellenar_Campos_Salida ();	
	}
}
