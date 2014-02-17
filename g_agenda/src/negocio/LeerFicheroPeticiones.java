package negocio;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import util.*;
public class LeerFicheroPeticiones  extends LeerFichero {

	private int anyo;
	private int mes;
	private int dias;
	private String [][] estMes; 
	private HashMap<String, String [][]> estructura = new HashMap<>();

	
	private int setMaxDias(int mes, int anyo){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MONTH, mes);
		ca.set(Calendar.YEAR, anyo);
		return ca.getActualMaximum(Calendar.DAY_OF_MONTH);
	} 
	
	private void TrataEntradas () throws Exception{
		 List<String> lista = super.getLista();
		 String[][] auxEstMes;
		 for (String peticion : lista) {
			 
			 auxEstMes = estructura.get(peticion.split(" ")[1]);
			 if (auxEstMes == null) {
				 auxEstMes = new String[this.dias] [24];
			 }
			 
			 //trato la petición -- void()
			 TratarFechas (peticion.split(" ")[1], peticion.split(" ")[2]);
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 estructura.put(peticion.split(" ")[1], auxEstMes );
			
		}
	}

	private void TratarFechas(String fechaInicio, String fechaFin) {
		// TODO Auto-generated method stub
		
	}

	public LeerFicheroPeticiones (String fichero, int anyo, int mes) throws Exception 
	{
		super(fichero);
		this.anyo= anyo;
		this.mes = mes;
		this.dias = this.setMaxDias(this.mes, this.anyo);
		
		TrataEntradas();
		
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
