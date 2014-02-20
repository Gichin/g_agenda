package main;

import negocio.EscribirIncidenciasLog;
import negocio.LeerFicheroConfig;
import negocio.LeerFicheroPeticiones;
import util.LeerFichero;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hola");		
		try {
			LeerFicheroConfig conf = new LeerFicheroConfig("config.txt");
			
			LeerFicheroPeticiones Peticiones = new LeerFicheroPeticiones("peticions.txt", conf.getAny(), conf.getMes(),
					conf.getIdiomaE(),conf.getIdiomaS());
			EscribirIncidenciasLog Log = new EscribirIncidenciasLog(Peticiones.getLog(), "incidencias.log");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
