package main;

import java.io.File;

import negocio.EscribeHTML;
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
			
			@SuppressWarnings("unused")
			EscribirIncidenciasLog Log = new EscribirIncidenciasLog(Peticiones.getLog(), "incidencias.log",Peticiones.getEstructura(),conf.getAny(), conf.getMes());


			EscribeHTML HTML = new EscribeHTML(Peticiones.getEstructura(), "c:\\documentos\\Agenda.HTM", conf);
			HTML.buildAgenda();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
