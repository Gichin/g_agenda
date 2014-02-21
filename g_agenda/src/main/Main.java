package main;

import negocio.EscribirIncidenciasLog;
import negocio.LeerFicheroConfig;
import negocio.LeerFicheroPeticiones;
import util.LeerFichero;

public class Main {

	public static void main(String[] args) 
	{
		try {
			LeerFicheroConfig conf = new LeerFicheroConfig("config.txt");
			
			LeerFicheroPeticiones Peticiones = new LeerFicheroPeticiones("peticions.txt", conf.getAny(), conf.getMes(),
					conf.getIdiomaE(),conf.getIdiomaS());
			
			EscribirIncidenciasLog Log = new EscribirIncidenciasLog(Peticiones.getLog(), "incidencias.log",Peticiones.getEstructura(),conf.getAny(), conf.getMes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
