package negocio;
import java.util.List;

import util.*;
public class EscribeHTML extends LeerFichero{

	EscribeLog Log = new EscribeLog();	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	private class EscribeLog extends EscribirFichero{

		public EscribeLog() {
			super(lista, nombreArchivo);
			// TODO Auto-generated constructor stub
		}

	}
}


