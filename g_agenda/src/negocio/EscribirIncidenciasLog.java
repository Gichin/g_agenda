package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import util.EscribirFichero;

public class EscribirIncidenciasLog extends EscribirFichero{
	
	private static int anyI = 0;
	private static int mesI = 0;		
	
	static List <String> TratarLista (List <String> lista)
	{
		String   Actividad1;	
		String slineas;		
		String [] Linea;	
		
		List<String> listaInciOrd = new ArrayList<String>();
		
		int iHoras = 0;
		int Total;	
		int hora1, hora2;
		int  Asignadas = 0;
		
		for (int i=0; i<lista.size(); i++)		
		{		
			slineas = lista.get(i);
			Linea= slineas.split(" ");	
			Actividad1 	= Linea[0];			
			hora1	= Integer.parseInt(Linea[8]);
			hora2=hora1+1;					
			
			if (i==0){				
				listaInciOrd.add("# Resum Activitats :\t" + mesI+ "/" +anyI);
				listaInciOrd.add("# Activitat  :\t\t\t" + Actividad1);
				listaInciOrd.add("");				
				listaInciOrd.add("Espai:   " + Linea[1] +"   Dia:   "+Linea[10]+ " - " +  Linea[7] + "/" + mesI +"/" + anyI +"\t   Hora:   "+ hora1 +"-" + hora2 +" \tConflicte con: \t" +  Linea[6]);
			}
			
			if ((i>0) && (Actividad1.equals(lista.get(i-1).split(" ")[0])))	{				
				iHoras++;
				Asignadas=Integer.parseInt(Linea[9])-iHoras;
				listaInciOrd.add("Espai:   " + Linea[1] +"   Dia:   "+Linea[10]+ " - " +  Linea[7] + "/" + mesI +"/" + anyI +"\t   Hora:   "+ hora1 +"-" + hora2 +" \tConflicte con: \t" +  Linea[6]);
			}
			else if (i==0){}
			else
			{							
				Total=Asignadas+iHoras ;		
				listaInciOrd.add("");			
				listaInciOrd.add("--------> Total: "+ Asignadas +" / "+ Total +" h assignades. (No Assignades:  " + iHoras + "  horas)");
				iHoras = 1;
				listaInciOrd.add("");
				listaInciOrd.add("# Resum Activitats :\t" + mesI+ "/" +anyI);
				listaInciOrd.add("# Activitat  :\t\t\t" + Actividad1);
				listaInciOrd.add("");
			}			
		}
		Total=Asignadas+iHoras ;
		listaInciOrd.add("");			
		listaInciOrd.add("--------> Total: "+ Asignadas +" / "+ Total +" h assignades. (No Assignades:  " + iHoras + "  horas)");					
		return listaInciOrd;
	}

	public  EscribirIncidenciasLog(List<String> lista, String nombreArchivo, HashMap <String, String[][]> estructura, int any, int mes) throws IOException
	{
		super(TratarLista(lista),nombreArchivo);	
		mesI=mes;
		anyI=any;	
		super.aDisco();
	}	
}
