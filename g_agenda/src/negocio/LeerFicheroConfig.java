//ESTHER


package negocio;

import java.io.IOException;
import java.util.List;

import util.*;

public class LeerFicheroConfig extends LeerFichero  
//ESTHER
{
	private  int any;
	private  int mes;
	private  String idiomaE;
	private  String idiomaS;	
	
	public int getAny() 			{	return any;		}
	public int getMes() 			{	return mes;			}
	public String getIdiomaE() 		{	return idiomaE;		}
	public String getIdiomaS() 		{	return idiomaS;		}
	
	

	public LeerFicheroConfig (String fichero) throws IOException
	{
		super (fichero);
		TratarLista (super.getLista());
	}

	private void TratarLista (List <String> lista)
	{
		String PrimLinea, SegundaLinea;
		
		PrimLinea=lista.get(0);
		SegundaLinea=lista.get(1);
		
		this.any = Integer.parseInt(PrimLinea.split(" ")[0]) ;
		this.mes = Integer.parseInt(PrimLinea.split(" ")[1]) ;
		this.idiomaE = SegundaLinea.split(" ")[0] ;
		this.idiomaS = SegundaLinea.split(" ")[1] ;				
	}
	
	public static void main(String[] args) {
		LeerFicheroConfig fiCon = null;
		try {			
			fiCon = new LeerFicheroConfig("config.txt");
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(fiCon.any);
		System.out.println(fiCon.mes);
		System.out.println(fiCon.idiomaE);
		System.out.println(fiCon.idiomaS);

	}
	

}
