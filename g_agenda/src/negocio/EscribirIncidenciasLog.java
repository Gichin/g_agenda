package negocio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import util.EscribirFichero;

public class EscribirIncidenciasLog {

	private List<String> lista = new ArrayList<String>();
	String nombreArchivo;
	
	public  EscribirIncidenciasLog(List<String> lista, String nombreArchivo) throws IOException{
		this.lista=lista;
		this.nombreArchivo=nombreArchivo;								
		
	PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);				
		
		for (int i=0; i<lista.size(); i++)			
		fichero.println(lista.get(i));	
		fichero.close();

		System.out.println("Fichero " + nombreArchivo + " generado.");
}
	
	public static void main(String[] args) throws IOException {
		
		List<String> list =	new ArrayList<String>() {
			{
				add("probando el bucle"); 
				add("#Activitat ReunioC");
				add("Espai: Sala1 Dia: X 19/11/2008 Hora: 10-11 Conflicte con: ReunioJava");
				add("Espai: Sala1 Dia: V 21/11/2008 Hora: 10-11 Conflicte con: ReunioJava");
				add("ultima entrada");}
			};
		
		
		EscribirFichero fichePepito=new EscribirFichero (list,"incidencias.log");
		System.out.println(fichePepito);
	}
}
