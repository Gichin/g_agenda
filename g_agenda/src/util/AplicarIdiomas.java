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
		String PrimLinea, dias, iniciales;
		
		PrimLinea=lista.get(0);
		dias=lista.get(1);
		iniciales=lista.get(2);
		
		System.out.println(dias);
		System.out.println(iniciales);
		
		
				
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