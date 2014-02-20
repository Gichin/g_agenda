package negocio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.EscribirFichero;


public class EscribirIncidenciasLog {// extends EscribirFichero{

	private List<String> lista = new ArrayList<String>();
	String nombreArchivo;
	
	public  EscribirIncidenciasLog(List<String> lista, String nombreArchivo, HashMap <String, String[][]> estructura) throws IOException
	{
		//	super(lista,nombreArchivo);
		
		PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);			
		for (int i=0; i<lista.size(); i++)			
		fichero.println(lista.get(i));	
		fichero.close();

		System.out.println("Fichero de Incidencias : " + nombreArchivo + " Se ha generado con Exito.");
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
				
			
			//EscribirIncidenciasLog Incidencias =new EscribirIncidenciasLog (list, "incidencias.log", LeerFicheroPeticiones.getEstructura);
		
			/*
			 * add("#Resum Activitats 11/2008"); 
				add("#Activitat ReunioC");
				add("Espai: Sala1 Dia: X 19/11/2008 Hora: 10-11 Conflicte con: ReunioJava");
				add("Espai: Sala1 Dia: V 21/11/2008 Hora: 10-11 Conflicte con: ReunioJava");
				add("--------> Total: 10 / 12 h assignades. (No Assignades: 4 h)");}
			*/
	
	}
}
