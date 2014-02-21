package negocio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import util.*;

public class EscribeHTML extends EscribirFichero {
	private HashMap<String, String [][]> horarios = new HashMap<>();
	private List<String> lista  = new ArrayList();
	private int mes;
	private int anyo;
	
	
	
	
	public void headerTable (String cabecera )
	{
		this.lista.add("<TABLE>");
		this.lista.add (" <caption>" +  cabecera + "</caption>");
		
	}
	public void footerTable ()
	{
		this.lista.add("</TABLE>");
	}
	public void bodyTable()
	{
		//saber el día de la semana en la que empieza el més
		//saber las semanas
		String[][] tHoras;
	
		
		
		
		for (Entry<String, String[][]> e: horarios.entrySet()) {
			headerTable(e.getKey().toString());
			tHoras = e.getValue();
			for(int linea = 0; linea < tHoras.length; linea++ )
			{
				this.lista.add("<TR>");
				for (int columna=0; columna<tHoras[linea].length; columna++)
				{
					this.lista.add(
							"<TD>" + tHoras[linea][columna] + "</TD>"
							);
				}
				this.lista.add("</TR>");
			}
	        
	    }
		
		
		dia1();
	}
	
	
	
	public void headerHTML ()
	{
		this.lista.add("<html>");
		this.lista.add("<head>");
		this.lista.add("</head>");
		this.lista.add("<body>");
	}
	public void footerHTML ()
	{
		this.lista.add("</table>");
		this.lista.add("</body>");
		this.lista.add("</html>");
	}
	
	public void bodyHTML()
	{
	
	}
	
	
	public void buildAgenda()
	{
		headerHTML();
		bodyHTML();
		footerHTML();
		System.out.println("Para!");
		
	}
	
	
	public EscribeHTML(HashMap<String, String [][]> horarios , String nombreArchivo, int mes, int anyo) throws IOException {		
			super(nombreArchivo);
			this.horarios = horarios;
			this.mes = mes;
			this.anyo = anyo;
			
			
		}
	
	private int dia1 (){
		Calendar  ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.set(Calendar.MONTH, this.mes);
		ca.set(Calendar.YEAR, this.anyo);
		int dia = ca.get(Calendar.DAY_OF_WEEK);
		int retorno; 
		switch (dia) {
		case 1: //DOMINGO
			retorno = (6); 
			break;
		case 2: //LUNES
			retorno =  (0);
			break;
		case 3: //MARTES
			retorno = (1);
			break;
		case 4: //MIERCOLES
			retorno = (2);
			break;
		case 5: //JUEVES
			retorno = (3);
			break;
		case 6: //VIERNES
			retorno = (4);
			break;
		case 7://SABADO
			retorno = (5);
			break;
		default:
			retorno = 0;
			break;
		}
		
		return retorno;		
	}
	
	
}



