package negocio;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import org.omg.CORBA.portable.IndirectionException;

import util.*;
public class LeerFicheroPeticiones  extends LeerFichero {

	private int anyo;
	private int mes;
	private int dias;
	private String [][] estMes; 
	private HashMap<String, String [][]> estructura = new HashMap<>();

	
	private int setMaxDias(int mes, int anyo){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MONTH, mes -1);
		ca.set(Calendar.YEAR, anyo);
		return ca.getActualMaximum(Calendar.DAY_OF_MONTH);
	} 
	
	private void TrataEntradas () throws Exception{
		 List<String> lista = super.getLista();
		 String[][] auxEstMes;
		 int inDias[];
		 int inHoras[];
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

	private int[] TratarFechas(String fechaInicio, String fechaFin) {
		int [] indiceDias= null;
		int diaInicio = Integer.parseInt(fechaInicio.split("/")[0]);
		int mesInicio = Integer.parseInt(fechaInicio.split("/")[1]);
		int diaFinal = Integer.parseInt(fechaFin.split("/")[0]);
		int mesFinal = Integer.parseInt(fechaFin.split("/")[1]);
		
		if (mesInicio == this.mes){
			if (mesFinal == this.mes){
				indiceDias = new int[diaFinal-diaInicio];
				for(int i =0; i <= (diaFinal-diaInicio);i++){
					indiceDias[i] = diaInicio + i;
				}
			}
			else if ((mesFinal <= this.mes) || (this.mes == 12)){
					indiceDias = new int[this.dias-diaInicio];
					for(int i =0; i <= (this.dias-diaInicio);i++){
						indiceDias[i] = diaInicio + i;
					}
			}
		}
		
		
		return indiceDias;

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
