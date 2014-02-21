package negocio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class EscribirIncidenciasLog {// extends EscribirFichero{

	private List<String> listaInci = new ArrayList<String>();
	private List<String> listaInciOrd = new ArrayList<String>();
	String nombreArchivo;
	private int anyI, mesI;
	String [] Linea;
	String slineas;
	
	private String  Thoras;
	

	String   Actividad1, Sala, dia, Actividad2;
	int  Asignadas;

	
	
	public  EscribirIncidenciasLog(List<String> lista, String nombreArchivo, HashMap <String, String[][]> estructura, int any, int mes) throws IOException
	{
		//	super(lista,nombreArchivo);		
		mesI=mes;
		anyI=any;	
		int iHoras = 0;
		int Total;	
		
		
		for (int i=0; i<lista.size(); i++)		{
			slineas = lista.get(i);
			Linea= slineas.split(" ");				
			
			Actividad1 	= Linea[0];
			
			int hora1, hora2;
			hora1		= Integer.parseInt(Linea[8]);
			hora2=hora1+1;
			
			if (i==0){
				
				listaInciOrd.add("# Resum Activitats :\t" + mesI+ "/" +anyI);
				listaInciOrd.add("# Activitat  :\t\t\t" + Actividad1);
				listaInciOrd.add("");				
				listaInciOrd.add("Espai:   " + Linea[1] +"   Dia:   "+Linea[10]+ " - " +  Linea[7] + "/" + mesI +"/" + anyI +"\t   Hora:   "+ hora1 +"-" + hora2 +" \tConflicte con: \t" +  Linea[6]);
			}
			
			if ((i>0) && (Actividad1.equals(lista.get(i-1).split(" ")[0])))				
			{
				
				iHoras++;
				Asignadas=Integer.parseInt(Linea[9])-iHoras;
				listaInciOrd.add("Espai:   " + Linea[1] +"   Dia:   "+Linea[10]+ " - " +  Linea[7] + "/" + mesI +"/" + anyI +"\t   Hora:   "+ hora1 +"-" + hora2 +" \tConflicte con: \t" +  Linea[6]);
				
			}
			else if (i==0){}
			else
			{							
				Total=Asignadas+iHoras ;		
				listaInciOrd.add("");			
				listaInciOrd.add("--------> Total: "+ Asignadas +" / "+ Total +" h assignades. (No Assignades:  " + iHoras + "  horas)");
				iHoras = 1;
				listaInciOrd.add("");
				listaInciOrd.add("# Resum Activitats :\t" + mesI+ "/" +anyI);
				listaInciOrd.add("# Activitat  :\t\t\t" + Actividad1);
				listaInciOrd.add("");
			}
			
		}
		Total=Asignadas+iHoras ;
		listaInciOrd.add("");			
		listaInciOrd.add("--------> Total: "+ Asignadas +" / "+ Total +" h assignades. (No Assignades:  " + iHoras + "  horas)");

		
			
		PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);			
		
		
			for (int i=0; i<listaInciOrd.size(); i++)			
			fichero.println(listaInciOrd.get(i));	
	
			Thoras      = Linea[9];
			Asignadas = Integer.parseInt(Thoras) - iHoras;
			
	//		fichero.println("");			
	//		fichero.println("--------> Total: "+ Asignadas +" / "+ Thoras +" h assignades. (No Assignades:  " + iHoras + "  horas)");
			
			fichero.close();			
				
	//		System.out.println("Espai: " + Sala +" Dia: "+Linea[10]+ " " + dia + "/" + mesI +"/" + anyI +" Hora: "+ hora1 +"-" + hora2 +" Conflicte con: " +  Actividad2);
			
					
		PrintWriter fichero2 = new PrintWriter( new BufferedOutputStream(new FileOutputStream("incidencias2.log")),true);
			
			for (int i=0; i<lista.size(); i++)			
			fichero2.println(lista.get(i));		
		
}
	
}
