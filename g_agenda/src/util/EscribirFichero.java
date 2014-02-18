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
			
			// Método constructor. Hay que pasar una lista con los datos, y el nombre del archivo que quieres generar
			public  EscribirFichero(List<String> lista, String nombreArchivo) throws IOException{
				this.lista=lista;
				this.nombreArchivo=nombreArchivo;
				
				
				
			// Creamos el fichero. También funciona con **PrintWriter pw = new PrintWriter(nombreArchivo);**
			PrintWriter fichero = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);				 
				
				// hacemos un bucle para leer el contenido de la lista y 
				//escribirlo en el fichero por líneas
				
					for (int i=0; i<lista.size(); i++)			
					fichero.println(lista.get(i));	
		
				fichero.close();//cerramos el fichero
		   	  	System.out.println("Fichero " + nombreArchivo + " generado.");
		}

			
			
			
			/*			public static void main(String[] args) throws IOException {
				
				List<String> listaPepito =				
						
						
						new ArrayList<String>() {{ add("probando el bucle"); add("#Activitat ReunioC");add("Espai: Sala1 Dia: X 19/11/2008 Hora: 10-11 Conflicte con: ReunioJava");add("Espai: Sala1 Dia: V 21/11/2008 Hora: 10-11 Conflicte con: ReunioJava");add("ultima entrada");}};
				
				
				EscribirFichero fichePepito=new EscribirFichero (listaPepito,"incidencias.log");
				System.out.println(fichePepito);
			}*/
			
	}









	
	
	
	//PrintWriter pw = new PrintWriter(nombreArchivo);
    // pw.println(lista);	

	/*private List<String> lista;
	private String fichero;

	public EscribirFichero(List<String> list, String fichero ){
		this.lista=list;
		this.fichero=fichero;
		
		//Cojes el parametro list y lo pasas al atributo.
		//abres y compruebas que exista el fichero, si no, lo creas.
	}

	public void Escribir(){
	lista.addAll(lista);	
		
	}

	//void Escribir que escriba la lista en el fichero



	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lst) {
		this.lista = lst;
	}
	*/
			 /* LinkedList<Punto> lista = new LinkedList<>();         
	         lista.add(new Punto(0,0));
	         lista.add(new Punto(1,1));
	         lista.add(new Punto(2,2));
	         lista.add(new Punto(5,5));
	         PrintWriter pw = 
	        	new PrintWriter("Fich.txt");
	         
	         pw.println(lista); */

