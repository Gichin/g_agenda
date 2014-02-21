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
	String nombreArchivo;
	private int anyI, mesI, iHoras;
	String [] Linea;
	String slineas;

	String Actividad, Sala, fInicio,ffinal, hora;

	
	
	public  EscribirIncidenciasLog(List<String> lista, String nombreArchivo, HashMap <String, String[][]> estructura, int any, int mes) throws IOException
	{
		//	super(lista,nombreArchivo);
		
		
		// 		ReunioPerl Sala1 01/09/2008 31/12/2008 LMJ 14-15_17-18
		
		for (int i=0; i<lista.size(); i++)			
		slineas = lista.get(i);
		Linea= slineas.split(" ");
		
		Actividad 	= Linea[0];
		Sala  		= Linea[1];
		fInicio		= Linea[2];
		ffinal		= Linea[3];
		hora		= Linea[5];
				
		System.out.println(Actividad + " " + Sala);
						
			
		PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);			
		
		for (int i=0; i<lista.size(); i++)			
			fichero.println(lista.get(i));	
			mesI=mes;
			anyI=any;	
			iHoras=lista.size();
			
			listaInci =	new ArrayList<String>() {
				{
					add("#Resum Activitats " + mesI+ "/" +anyI); 
				
					add("#Activitat ------");
					add("Espai: ----- Dia: -  --------- Hora: -- - -- Conflicte con: --------");
					add("Espai: ----- Dia: -  --------- Hora: -- - -- Conflicte con: --------");
					add("--------> Total: 10 / 12 h assignades. (No Assignades:  " + iHoras + "  horas)");}
				};
				
		for (int i=0; i<listaInci.size(); i++)			
			fichero.println(listaInci.get(i));	
			
			
		
			
		fichero.close();
		
		System.out.println("Fichero de Incidencias : " + nombreArchivo + " Se ha generado con Exito.");		
	
		
		//System.out.println(estructura.get("Sala1"));
		
		
		for (Entry <String, String[][]> m : estructura.entrySet()){
			
			System.out.println("Desde EscribirIncidenciasLog : " + m.getKey()+ " - " + m.getValue()[1][2]);
		}
		
			
	//	estructura.getauxEstMes[inHoras[0]][inDias[0]];
		
		
}
	
	public static void main(String[] args) throws IOException {
		
		List<String> list =	new ArrayList<String>() {
			{
				add("#Resum Activitats -- / ----"); 
				add("#Activitat ------");
				add("Espai: ----- Dia: -  --------- Hora: -- - -- Conflicte con: --------");
				add("Espai: ----- Dia: -  --------- Hora: -- - -- Conflicte con: --------");
				add("--------> Total: 10 / 12 h assignades. (No Assignades: 4 h)");}
			};
				
			
		//	LeerFicheroPeticiones Pet =new LeerFIcheroPeticiones ("peticions.txt", int anyo, int mes, String idiomaE, String idiomaS);
			
	//		EscribirIncidenciasLog Incidencias =new EscribirIncidenciasLog (list, "incidencias.log", LeerFicheroPeticiones.  );
		
			/*
			 * add("#Resum Activitats 11/2008"); 
				add("#Activitat ReunioC");
				add("Espai: Sala1 Dia: X 19/11/2008 Hora: 10-11 Conflicte con: ReunioJava");
				add("Espai: Sala1 Dia: V 21/11/2008 Hora: 10-11 Conflicte con: ReunioJava");
				add("--------> Total: 10 / 12 h assignades. (No Assignades: 4 h)");}
			*/
	
	}
}
