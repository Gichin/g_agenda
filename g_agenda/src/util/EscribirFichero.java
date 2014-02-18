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
			String nombreArchivo;

			public  EscribirFichero(List<String> lista, String nombreArchivo) throws IOException{
				this.lista=lista;
				this.nombreArchivo=nombreArchivo;
				//System.out.println(lista);
				
				//PrintWriter pw = new PrintWriter(nombreArchivo);
				
			PrintWriter pw = new PrintWriter( new BufferedOutputStream(new FileOutputStream(nombreArchivo)),true);				 
			        				
				pw.println(lista.get(0));				
				pw.println(lista.get(1)); 
				pw.println(lista.get(2));				
				pw.println(lista.get(3)); 
				pw.println(lista.get(4)); 
				    
		      
				 
		        pw.close();
		   	  	System.out.println("Fichero " + nombreArchivo + " generado.");
				 
		
		}
			public static void main(String[] args) throws IOException {
				
				List<String> listaPepito =				
						
						
						new ArrayList<String>() {{ add("#Resum Activitats 11/2008"); add("#Activitat ReunioC");add("Espai: Sala1 Dia: X 19/11/2008 Hora: 10-11 Conflicte con: ReunioJava");add("Espai: Sala1 Dia: V 21/11/2008 Hora: 10-11 Conflicte con: ReunioJava");add("--------> Total: 10 / 12 h assignades. (No Assignades: 4 h)");}};
				
				
				EscribirFichero fichePepito=new EscribirFichero (listaPepito,"incidencias.log");
				System.out.println(fichePepito);
			}
			
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

