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
	private List<String> log  = new ArrayList();
	private String idiomaE, idiomaS ;
	private AplicarIdiomas Trad;
	
	
	

	
	private int setMaxDias(int mes, int anyo){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MONTH, mes );
		ca.set(Calendar.YEAR, anyo);
		return ca.getActualMaximum(Calendar.DAY_OF_MONTH);
	} 
	
	private void TrataEntradas () throws Exception{
		 List<String> lista = super.getLista();
		 String[][] auxEstMes;
		 int inDias[];
		 int inHoras[];
		 String dentroMes, comp1, comp2;
		 
		 
		 
		 
		 for (String peticion : lista) {
			 dentroMes = DentroMes (peticion.split(" ")[2], peticion.split(" ")[3]);
			 
			 if (dentroMes == "si") {
				 
				 
				 auxEstMes = estructura.get(peticion.split(" ")[1]);
				 if (auxEstMes == null) {
					 auxEstMes = new String[24][this.dias] ;
				 }
				 
				 //trato la petición -- void()
				 inDias = new int[(TratarFechas (peticion.split(" ")[2], peticion.split(" ")[3])).length];
				 inDias = TratarFechas (peticion.split(" ")[2], peticion.split(" ")[3]);			 
				 inHoras = new int[(Utiles.Horas_Array(peticion.split(" ")[5])).length];
				 inHoras = Utiles.Horas_Array(peticion.split(" ")[5]);
		
				 
				 
				 for (int i=0; i<(inDias.length-1); i++)
				 {
					 int esDiaActivo = peticion.split(" ")[4].indexOf(Utiles.DiadelaSemana((inDias[i]), this.mes, this.anyo, this.Trad));
					 System.out.println("Día " + (inDias[i])+ "/"+ this.mes + "/" +this.anyo + 
							 " esDiActivo: "+ esDiaActivo +  " en " + peticion.split(" ")[4] + "/n");
					 if (esDiaActivo != -1){

					 
					 
						 for (int x=0; x<inHoras.length; x++){
							 // OJO Cambiar Tancat por lenguaje de entrada!!!!!!
							 comp1 = peticion.split(" ")[0];
							 comp2 = Trad.getCerradoE();
							 
							 if ((auxEstMes[x][i]==null) ){
								 
									 
									 if (comp1.equals(comp2))
									 //if (peticion.split(" ")[0] == Trad.getCerradoE())
									 {
										 System.out.println("Dia " + (inDias[i]) +  "Hora " + inHoras[x] + Trad.getCerradoS() );
										 auxEstMes[inHoras[x]][inDias[i]]= Trad.getCerradoS();
									 }
									 else
									 {
										 System.out.println("Dia " + (inDias[i]) +  "Hora " + inHoras[x] + peticion.split(" ")[0]);
										 auxEstMes[inHoras[x]][inDias[i]]= peticion.split(" ")[0];
									 }
								 
							 }
							 //(peticion.split(" ")[0] != Trad.getCerradoE()){
							 else if  (  !(comp1.equals(comp2)) ) {
								 log.add(peticion);
							 }
						 }//for horas	 
					 }//If Dia Activo
				 }//for Dias
				 estructura.put(peticion.split(" ")[1], auxEstMes );
			 }
		 }
	}
	
	
	private String DentroMes (String fechaInicio, String fechaFin) {
		Calendar fInicio = Calendar.getInstance();
		Calendar fFin = Calendar.getInstance();
		int diaI, mesI, anyoI, diaF, mesF, anyoF = 0;
		
		diaI = Integer.parseInt(fechaInicio.split("/")[0]);
		mesI = Integer.parseInt(fechaInicio.split("/")[1]);
		anyoI= Integer.parseInt(fechaInicio.split("/")[2]);
		fInicio.clear();
		fInicio.set(Calendar.YEAR, anyoI);
		fInicio.set(Calendar.MONTH, mesI-1);
		fInicio.set(Calendar.DAY_OF_MONTH, diaI);

		
		diaF = Integer.parseInt(fechaFin.split("/")[0]);
		mesF = Integer.parseInt(fechaFin.split("/")[1]);
		anyoF= Integer.parseInt(fechaFin.split("/")[2]);
		fFin.clear();
		fFin.set(Calendar.YEAR, anyoF);
		fFin.set(Calendar.MONTH, mesF-1);
		fFin.set(Calendar.DAY_OF_MONTH, diaF);
		int inicio, fin, aInicio, aFin = 0;
		inicio = fInicio.get(Calendar.MONTH);
		fin = fFin.get(Calendar.MONTH);
		aInicio = fInicio.get(Calendar.YEAR);
		aFin = fFin.get(Calendar.YEAR);
		
		
		if ((inicio <= this.mes) &&	(this.mes <= fin) 
				&& (aInicio <= this.anyo) && (this.anyo <= aFin)) {
			return "si";
			
		}
		else
		{
			return "no";
		}
				
				
				
		
	}
	

	private int[] TratarFechas(String fechaInicio, String fechaFin) {
		
		
		Calendar fInicio = Calendar.getInstance();
		Calendar fFin = Calendar.getInstance();
		int diaI, mesI, anyoI, diaF, mesF, anyoF = 0;
		
		diaI = Integer.parseInt(fechaInicio.split("/")[0]);
		mesI = Integer.parseInt(fechaInicio.split("/")[1]);
		anyoI= Integer.parseInt(fechaInicio.split("/")[2]);
		fInicio.clear();
		fInicio.set(Calendar.YEAR, anyoI);
		fInicio.set(Calendar.MONTH, mesI-1);
		fInicio.set(Calendar.DAY_OF_MONTH, diaI);

		
		diaF = Integer.parseInt(fechaFin.split("/")[0]);
		mesF = Integer.parseInt(fechaFin.split("/")[1]);
		anyoF= Integer.parseInt(fechaFin.split("/")[2]);
		fFin.clear();
		fFin.set(Calendar.YEAR, anyoF);
		fFin.set(Calendar.MONTH, mesF-1);
		fFin.set(Calendar.DAY_OF_MONTH, diaF);

		

		
		int compara;
		int indice = 0;
		int uBound = 0;
		ArrayList<Integer> dias = new ArrayList<Integer>();
		compara = fInicio.compareTo(fFin);

		//Si es negativo fInicio es antes que fFin. 0 son iguales. >0 FInicio es después de fFin		
			while (compara<=0){
				
				if ((fInicio.get(Calendar.MONTH) == this.mes) && (fInicio.get(Calendar.YEAR) == this.anyo)){
					dias.add((Integer)fInicio.get(Calendar.DAY_OF_MONTH));
					System.out.println(fInicio.getTime());
				}
				
				fInicio.add(Calendar.DAY_OF_MONTH, 1);
				compara = fInicio.compareTo(fFin);
			}
			
			int [] indiceDias = new int [dias.size()];
			
			for (int i=0 ; i < indiceDias.length; i++){
				indiceDias[i]= dias.get(i);
			}
			
			return indiceDias;
	}


		
				

	public LeerFicheroPeticiones (String fichero, int anyo, int mes, String idiomaE, String idiomaS) throws Exception 
	{
		super(fichero);
		this.anyo= anyo;
		this.mes = mes-1;
		this.dias = this.setMaxDias(this.mes, this.anyo);
		this.idiomaE = idiomaE;
		this.idiomaS = idiomaS;
		this.Trad = new AplicarIdiomas(this.idiomaE, this.idiomaS);
		
		
		
		TrataEntradas();
		
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> lista = new ArrayList<>();
//		lista.add("Tancat Sala1 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24");
//		lista.add("Tancat Sala1 25/12/2008 25/12/2008 LMCJVSG 00-24");
//		lista.add("Tancat Sala1 01/01/2009 31/12/2008 G 00-24");
//		lista.add("Tancat Sala2 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24");
//		lista.add("ReunioPerl Sala1 01/05/2008 31/05/2008 LMJ 12-13_17-18");
//		lista.add("ReunioPerl Sala1 01/06/2008 02/02/2008 LMCJV 14-18");
//		lista.add("ReunioPerl Sala1 01/07/2008 20/12/2008 LMJ 13-14_17-18");
//		lista.add("ReunioPerl Sala1 01/08/2008 02/02/2008 LMCJV 14-18");
//		lista.add("ReunioPerl Sala1 01/09/2008 31/12/2008 LMJ 14-15_17-18");
//		lista.add("ReunioJava Sala1 15/10/2008 20/12/2008 LMCJV 12-21");
//		lista.add("ReunioJava Sala1 25/09/2008 02/11/2008 LMCJV 14-18");
//		lista.add("ReunioJava Sala1 25/09/2008 02/11/2008 LMCJV 12-14");
		
		try {
			LeerFicheroConfig conf = new LeerFicheroConfig("config.txt");
			
			LeerFicheroPeticiones Peticiones = new LeerFicheroPeticiones("peticions.txt", conf.getAny(), conf.getMes(),
					conf.getIdiomaE(),conf.getIdiomaS());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
