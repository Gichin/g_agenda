package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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
				 auxEstMes = new String[24][this.dias] ;
			 }
			 
			 //trato la petición -- void()
			 inDias = new int[(TratarFechas2 (peticion.split(" ")[2], peticion.split(" ")[3])).length];
			 inDias = TratarFechas2 (peticion.split(" ")[2], peticion.split(" ")[3]);			 
			 inHoras = new int[(Utiles.Horas_Array(peticion.split(" ")[5])).length];
			 inHoras = Utiles.Horas_Array(peticion.split(" ")[5]);
			 
			 for (int i=0; i<inDias.length; i++){
				 for (int x=0; x<inHoras.length; x++){
					 // OJO Cambiar Tancat por lenguaje de entrada!!!!!!
					 if ((auxEstMes[x][i]==null)||  (peticion.split(" ")[0] == "Tancat")){
						 auxEstMes[x][i]= peticion.split(" ")[0];
					 }
					 
				 }
				 
			 }
			 estructura.put(peticion.split(" ")[1], auxEstMes );
			
		}
	}

	private int[] TratarFechas2(String fechaInicio, String fechaFin) {
		
		
		Calendar fInicio = Calendar.getInstance();
		Calendar fFin = Calendar.getInstance();
		int diaI, mesI, anyoI, diaF, mesF, anyoF = 0;
		
		diaI = Integer.parseInt(fechaInicio.split("/")[0]);
		mesI = Integer.parseInt(fechaInicio.split("/")[1]);
		anyoI= Integer.parseInt(fechaInicio.split("/")[2]);
		fInicio.clear();
		fInicio.set(Calendar.YEAR, anyoI);
		fInicio.set(Calendar.MONTH, mesI);
		fInicio.set(Calendar.DAY_OF_MONTH, diaI);
		
		/*
		 fInicio.set(Integer.parseInt(fechaInicio.split("/")[2]),
				Integer.parseInt(fechaInicio.split("/")[1]), 
				Integer.parseInt(fechaInicio.split("/")[0]));
		*/
		fFin.set(Integer.parseInt(fechaFin.split("/")[2]), 
				Integer.parseInt(fechaFin.split("/")[1]), 
				Integer.parseInt(fechaFin.split("/")[0]));
		int compara;
		int indice = 0;
		int uBound = 0;
		ArrayList<Integer> dias = new ArrayList<Integer>();
		compara = fInicio.compareTo(fFin);
		//Si es negativo fInicio es antes que fFin. 0 son iguales. >0 FInicio es después de fFin		
			while (compara<0){
				
				if ((fInicio.MONTH == this.mes) && (fInicio.YEAR == this.anyo)){
					dias.add((Integer)fInicio.DAY_OF_MONTH);
					
				}
				
				fInicio.add(fInicio.DAY_OF_MONTH, 1);
				compara = fInicio.compareTo(fFin);
			}
			
			int [] indiceDias = new int [dias.size()];
			
			for (int i=0 ; i < indiceDias.length; i++){
				indiceDias[i]= dias.get(i);
			}
			
			return indiceDias;
	}


		
		/*
		if ((fInicio.YEAR==this.anyo) && (fFin.YEAR==this.anyo)){
			if ((fInicio.MONTH < this.mes) && (this.mes < fFin.MONTH) ){
				uBound = this.dias;
				
			}
			else if ((fInicio.MONTH < this.mes) && (this.mes == fFin.MONTH)){
				iBound = fFin.DATE;
			}
			else if ((fInicio.MONTH == this.mes) && (this.mes < fFin.MONTH)){
				iBound = F
			}

		}
		else if((fInicio.YEAR==this.anyo) && (fFin.YEAR>=this.anyo)){}
		*/
				

	private int[] TratarFechas(String fechaInicio, String fechaFin) {
		int [] indiceDias= null;
		int diaInicio = Integer.parseInt(fechaInicio.split("/")[0]);
		int mesInicio = Integer.parseInt(fechaInicio.split("/")[1]);
		int diaFinal = Integer.parseInt(fechaFin.split("/")[0]);
		int mesFinal = Integer.parseInt(fechaFin.split("/")[1]);
		
		if (mesInicio <= this.mes){
			if (mesFinal == this.mes){
				indiceDias = new int[diaFinal-diaInicio];
				for(int i =0; i <= (diaFinal-diaInicio);i++){
					indiceDias[i] = diaInicio + i;
				}
			}
			else if (mesFinal>=this.mes){
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
		List<String> lista = new ArrayList<>();
		lista.add("Tancat Sala1 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24");
		lista.add("Tancat Sala1 25/12/2008 25/12/2008 LMCJVSG 00-24");
		lista.add("Tancat Sala1 01/01/2009 31/12/2008 G 00-24");
		lista.add("Tancat Sala2 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24");
		lista.add("ReunioPerl Sala1 01/05/2008 31/05/2008 LMJ 12-13_17-18");
		lista.add("ReunioPerl Sala1 01/06/2008 02/02/2008 LMCJV 14-18");
		lista.add("ReunioPerl Sala1 01/07/2008 20/12/2008 LMJ 13-14_17-18");
		lista.add("ReunioPerl Sala1 01/08/2008 02/02/2008 LMCJV 14-18");
		lista.add("ReunioPerl Sala1 01/09/2008 31/12/2008 LMJ 14-15_17-18");
		lista.add("ReunioJava Sala1 15/10/2008 20/12/2008 LMCJV 12-21");
		lista.add("ReunioJava Sala1 25/09/2008 02/11/2008 LMCJV 14-18");
		lista.add("ReunioJava Sala1 25/09/2008 02/11/2008 LMCJV 12-14");
		
		try {
			LeerFicheroPeticiones Peticiones = new LeerFicheroPeticiones("peticions.txt", 2008, 11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
