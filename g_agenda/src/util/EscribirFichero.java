package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MailcapCommandMap;

	/**
	 * @author poo
	 *
	 */
	public class EscribirFichero {
		
			private List<String> lista = new ArrayList<String>();
			String nombreArchivo;
			
			// M�todo constructor. Hay que pasar una lista con los datos, y el nombre del archivo que quieres generar
			public  EscribirFichero(List<String> lista, String nombreArchivo) throws IOException{
				this.lista=lista;
				this.nombreArchivo=nombreArchivo;								
				
			// Creamos el fichero. Tambi�n funciona con **PrintWriter pw = new PrintWriter(nombreArchivo);**
			PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);				 
				
				// hacemos un bucle para leer el contenido de la lista y 
				//escribirlo en el fichero por l�neas
				
					for (int i=0; i<lista.size(); i++)			
					fichero.println(lista.get(i));	
		
				fichero.close();//cerramos el fichero
		   	  	System.out.println("Fichero " + nombreArchivo + " generado.");
		}

			
			
			
			public static void main(String[] args) throws IOException {
				
				List<String> listaPepito =				
						
						new ArrayList<String>() {{ add("probando el bucle"); add("#Activitat ReunioC");add("Espai: Sala1 Dia: X 19/11/2008 Hora: 10-11 Conflicte con: ReunioJava");add("Espai: Sala1 Dia: V 21/11/2008 Hora: 10-11 Conflicte con: ReunioJava");add("ultima entrada");}};
				
				
				EscribirFichero fichePepito=new EscribirFichero (listaPepito,"incidencias.log");
				System.out.println(fichePepito);
			}
			
	}

