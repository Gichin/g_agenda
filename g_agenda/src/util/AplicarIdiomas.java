package util;

import java.io.IOException;
import java.util.List;

import negocio.LeerFicheroConfig;

public class AplicarIdiomas {
	
	//Esther	
	
	
	private String [] LineaE;			
	private String [] LineaS;
	
	private String []  DiasE;
	private String []  DiasS;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String DiasIE;
	private String DiasIS;
	
	private String MesesE;
	private String MesesS;
	
	
	
	private String LunesE,MartesE,MiercolesE,JuevesE,ViernesE,SabadoE,DomingoE;
	private String LunesS,MartesS,MiercolesS,JuevesS,ViernesS,SabadoS,DomingoS;
	
	private String LE,ME,XE,JE,VE,SE,DE;
	private String LS,MS,XS,JS,VS,SS,DS;
	
	private String CerradoE;
	private String CerradoS;
	

	private LeerFichero IdiomaE;
	private LeerFichero IdiomaS;
	
	
	public AplicarIdiomas (String idEntrada, String idSalida) throws Exception
	{
		this.IdiomaE = new LeerFichero("internacional."+idEntrada);
		this.IdiomaE.getLista();
		this.IdiomaS = new LeerFichero("internacional."+idSalida);
		this.IdiomaS.getLista();		
	}
	
	
	public void Rellenar_Campos_Entrada ()
	{
		String preparadaParaSplit = "";
		
		for (String linea : IdiomaE.getLista()) {
			preparadaParaSplit += linea;
		}		
		System.out.println(preparadaParaSplit);		
		
		LineaE = preparadaParaSplit.split(";");
		
		System.out.println(LineaE[1]);		
		
	}
	
	
	public void Rellenar_Campos_Salida ()
	{	
		String preparadaParaSplit = "";
		
		for (String linea : IdiomaS.getLista()) {
			preparadaParaSplit += linea;
		}		
		System.out.println(preparadaParaSplit);				
	}
	
	
	public static void main(String[] args)	{
		try {
			
			AplicarIdiomas idioma = new AplicarIdiomas ("CAT", "ENG");		
			idioma.Rellenar_Campos_Entrada ();
			idioma.Rellenar_Campos_Salida ();

			
			
		//	System.out.println(idioma.IdiomaE.getLista());
		//	System.out.println(idioma.IdiomaS.getLista());
			
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	

}