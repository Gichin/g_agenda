package util;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utiles {		
	
	public static int [] Horas_Array(String Hor)  throws Exception  //ESTHER
	{			
				
		String [] Parte = Hor.split("_");		
		String [] Parte1;
		String [] Parte2;				
		Parte1 =(Parte[0].split("-"));
		
		int hora1I, hora1F, hora1T;
		int hora2I = 0, hora2F = 0, hora2T = 0;
		int ArryT = 0;	
						
		hora1I=Integer.parseInt(Parte1 [0]);
		hora1F=Integer.parseInt(Parte1 [1]);
		
		hora1T=hora1F-hora1I;			
		int[] iHora1 = new int[hora1T];					
		ArryT= hora1T;
		
		if (Parte.length >1)  {			
			Parte2 =(Parte[1].split("-"));
			
			hora2I=Integer.parseInt(Parte2 [0]);
			hora2F=Integer.parseInt(Parte2 [1]);
			hora2T=hora2F-hora2I;			
			int[] iHora2 = new int[hora2T];					
			ArryT=ArryT+hora2T;		
		}
					
		int[] Arry = new int[ArryT];		
		int i = 0;
		
		for (int n:iHora1){			
			Arry[i]=hora1I;			
			i++;
			hora1I++;
		}
		
		int[] iHora2 = new int[hora2T];	
		
		for (int n:iHora2){					
			Arry[i]=hora2I;			
				i++;
			hora2I++;
		}	
		return Arry;	
	}
	
	public static char DiadelaSemana(int dia, int mes, int any, AplicarIdiomas Idioma)  throws Exception  //ESTHER
	{			
		Calendar ca = Calendar.getInstance();		
        ca.set(Calendar.DAY_OF_MONTH, dia);
        ca.set(Calendar.MONTH, mes );
        ca.set(Calendar.YEAR, any);	    
        int numDia= ca.get(Calendar.DAY_OF_WEEK);        
        char letra = 0;		
        
        switch (numDia) {
		case 1:		
			letra=Idioma.getDE();
			break;
		case 2:			
			letra=Idioma.getLE();
			break;
		case 3:			
			letra=Idioma.getME();
		break;
		case 4:			
			letra=Idioma.getXE();
			break;
		case 5:			
			letra=Idioma.getJE();
			break;
		case 6:			
			letra=Idioma.getVE();
			break;
		case 7:			
			letra=Idioma.getSE();
			break;
		default:
			break;
		}       		
		return letra;	  
		
	}
	
	public static void main(String[] args) throws Exception {	
		
		AplicarIdiomas rr = new AplicarIdiomas("CAT", "ENG");
			
			Horas_Array ("08-12");
			Horas_Array ("08-11_15-20");					
			DiadelaSemana(20, 2, 2014, rr);
}		

}
