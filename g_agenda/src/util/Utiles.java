package util;

import java.util.ArrayList;
import java.util.List;

public class Utiles {
	

	public static int [] Horas_Array(String Hor)	{		
				
		String [] Parte = Hor.split("_");		
		String [] Parte1;
		String [] Parte2;				
		Parte1 =(Parte[0].split("-"));	
		int horaI, horaF, horaT;
				
		horaI=Integer.parseInt(Parte1 [0]);
		horaF=Integer.parseInt(Parte1 [1]);
		horaT=horaF-horaI;
		
		int[] iHora1 = new int[horaT];	
		int[] iHora2 = null ;	
		
		if (horaT ==1)
		{
			iHora1 [0]=horaI;	
		}else{
		
		for (int i=1; i!=horaT; i++)
		{
			iHora1 [0]=horaI;	
			iHora1 [i]=horaI+1;	
		}
		}			
				
		if (Parte.length >1)  {			
			Parte2 =(Parte[1].split("-"));
			
			horaI=Integer.parseInt(Parte2 [0]);
			horaF=Integer.parseInt(Parte2 [1]);
			horaT=horaF-horaI;
			
			iHora2 = new int[horaT];	
			if (horaT ==1)
			{
				iHora2 [0]=horaI;	
			}else{
				int cont=horaI;
			for (int i=1; i!=horaT; i++)			
			{			
				iHora2 [0]=horaI;	
				iHora2 [i]=cont+1;	
				cont++;
			}
					
			}
			
		}
		
		int ArryT = 0;		
		
		if ( iHora2 != null)  
			{
				ArryT= iHora1.length + iHora2.length;
			}else
			{
				ArryT= iHora1.length ;
			}
					
		
		int[] Arry = new int[ArryT];	
		int total=0;
			
		if ( iHora2.length==0)
		{	for (int n: iHora1)
		{
			total+=n;			
			Arry [n] = iHora1 [n];	
		}
			
		}else
		{	
		for ( int i: Arry)	{			
			
			for (int n: iHora1)
			{
				total+=n;			
				Arry [i] = iHora1 [n];	
			}
			 total=0; 
			 
			 for (int x: iHora2)
			{
				total+=x;			
			Arry [i] = iHora1 [x];	
			}	
		}
		}		
		
		return Arry;			
	}
	public static void main(String[] args) {
		
	
	
		Horas_Array ("08-9");
		Horas_Array ("08-09_15-20");
		
		

	}

}
