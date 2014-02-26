//ESTHER

package util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerFichero 

//ESTHER
{
	private List<String> lista = new ArrayList<String>();	
	
	public LeerFichero() throws Exception
	{
		
	}
	
	public LeerFichero (String Fichero) throws IOException	{
	      String lineafichero;      

         BufferedReader buffer = new BufferedReader
        		 ( new InputStreamReader(
        				 new FileInputStream(Fichero),"UTF-8"));		      
			         
         while ((lineafichero=buffer.readLine())!=null)
		    lista.add(lineafichero);
     	//	System.out.println(lista);
		
	}
	
	
	public static void main(String[] args)	{		
		
		try {
			LeerFichero LeerC = new LeerFichero("config.txt");		
			} catch (IOException e) {
		e.printStackTrace();
			}
		
	
		try {
			LeerFichero LeerP = new LeerFichero("peticions.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		try {
			LeerFichero LeerI = new LeerFichero("internacional.cat");
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}

	public  List<String> getLista() {
		return lista;
	}
	
	
	
}