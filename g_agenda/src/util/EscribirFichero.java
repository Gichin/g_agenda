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


	public class EscribirFichero {
		
			private List<String> lista = new ArrayList<String>();
			private String nombreArchivo;
			
			public void aDisco () throws FileNotFoundException{
				PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);				 
				
				// hacemos un bucle para leer el contenido de la lista y 
				//escribirlo en el fichero por líneas
				
				for (int i=0; i<lista.size(); i++)			
						fichero.println(lista.get(i));	
					
				fichero.close();//cerramos el fichero
		   	  	System.out.println("Fichero " + nombreArchivo + " generado.");
				
			}
			
			public void aDisco (List<String> lista) throws FileNotFoundException{
				this.lista = lista;
				PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);				 
				
				// hacemos un bucle para leer el contenido de la lista y 
				//escribirlo en el fichero por líneas
				
				for (int i=0; i<lista.size(); i++)			
						fichero.println(lista.get(i));	
					
				fichero.close();//cerramos el fichero
		   	  	System.out.println("Fichero " + nombreArchivo + " generado.");
				
			}
			
			// Método constructor. Hay que pasar una lista con los datos, y el nombre del archivo que quieres generar
			
			public  EscribirFichero(List<String> lista, String nombreArchivo) throws IOException{
				this.lista=lista;
				this.nombreArchivo=nombreArchivo;				
			}

			public  EscribirFichero (String nombreArchivo){
				this.nombreArchivo = nombreArchivo;
			}			
	}

