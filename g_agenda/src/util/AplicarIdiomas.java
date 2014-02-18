package util;

import java.io.IOException;
import java.util.List;

import negocio.LeerFicheroConfig;

public class AplicarIdiomas extends LeerFichero{
	
	
	public AplicarIdiomas (String fichero) throws IOException
	{
		super (fichero);		
		TratarLista (super.getLista());
	}
	
	
	private void TratarLista (List <String> lista)
	{
		String PrimLinea, dias, iniciales, tempo, gener, cerr, err;
		
		PrimLinea=lista.get(0);
		dias=lista.get(1);
		iniciales=lista.get(2);
		tempo=lista.get(3);
		gener=lista.get(4);
		cerr=lista.get(5);
		err=lista.get(6);
		
		
		Split (String PrimLinea: PrimLinea.split(",",2));
		
				String Str = new String();
			
				String PrimLinea=lista.get(0);
				String[] splits = PrimLinea.split(",");

				System.out.println("splits.size: " + splits.length);

				for(String asset: assetClasses){
				System.out.println(asset);
				}


				

			      System.out.println("dias");
			      for (String Str1: PrimLinea.split(",", 2)){
			         System.out.println(dias);
			      
		
		
		System.out.println(iniciales);
		System.out.println(tempo);
		System.out.println(gener);
		System.out.println(cerr);
		System.out.println(err);
		
				
	}
	
	public static void main(String[] args)
	{
		try {
		
			
			AplicarIdiomas idioma = new AplicarIdiomas("internacional.cat");
			
				
			
			
	//		PrimLinea=idioma.get(0);
	//		SegundaLinea=idioma.get(1);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	

		
	}
	

}