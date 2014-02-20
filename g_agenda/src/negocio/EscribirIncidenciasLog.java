package negocio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.EscribirFichero;
import negocio.LeerFicheroPeticiones;


public class EscribirIncidenciasLog {// extends EscribirFichero{

	private List<String> listaInci = new ArrayList<String>();
	String nombreArchivo;
	private int anyI, mesI;
	
	public  EscribirIncidenciasLog(List<String> lista, String nombreArchivo, HashMap <String, String[][]> estructura, int any, int mes) throws IOException
	{
		//	super(lista,nombreArchivo);
		
		
		mesI=mes;
		anyI=any;
		
		listaInci =	new ArrayList<String>() {
			{
				add("#Resum Activitats " + mesI+ "/" +anyI); 
				add("#Activitat ------");
				add("Espai: ----- Dia: -  --------- Hora: -- - -- Conflicte con: --------");
				add("Espai: ----- Dia: -  --------- Hora: -- - -- Conflicte con: --------");
				add("--------> Total: 10 / 12 h assignades. (No Assignades: 4 h)");}
			};
		
	
		
		
		PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);			
		for (int i=0; i<listaInci.size(); i++)			
		fichero.println(listaInci.get(i));	
		fichero.close();
		
		System.out.println("Fichero de Incidencias : " + nombreArchivo + " Se ha generado con Exito.");
		
		System.out.println(estructura.get("Sala1"));
		
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
