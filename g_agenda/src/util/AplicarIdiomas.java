package util;

import java.io.IOException;
import java.util.List;

import negocio.LeerFicheroConfig;

public class AplicarIdiomas {
	
	//Esther	

	
	 // ATRIBUTOS PARA IDIOMA ENTRADA 
	
	String Linea;	
	private String [] LineaE;			
	private String [] LineaS;
	
	
	private String AgendaE;			
	private String LunesE,MartesE,MiercolesE,JuevesE,ViernesE,SabadoE,DomingoE;
	private char LE,ME,XE,JE,VE,SE,DE;	
	private String EneroE,FebreroE,MarzoE,AbrilE,MayoE,JunioE,JulioE,AgostoE,SeptiembreE,OctubreE,NoviembreE,DiciembreE;
	private String DiaE,MesE,AnyE,SemE;	
	private String CerradoE;
	private String GeneradoE;


	 // ATRIBUTOS PARA IDIOMA SALIDA 
	
	private String AgendaS;
	private String LunesS,MartesS,MiercolesS,JuevesS,ViernesS,SabadoS,DomingoS;
	private char LS,MS,XS,JS,VS,SS,DS;
	private String EneroS,FebreroS,MarzoS,AbrilS,MayoS,JunioS,JulioS,AgostoS,SeptiembreS,OctubreS,NoviembreS,DiciembreS;	
	private String DiaS,MesS,AnyS,SemS;		
	private String CerradoS;
	private String GeneradoS;
		
	private LeerFichero IdiomaE;
	private LeerFichero IdiomaS;	
		
	public LeerFichero getIdiomaE() {	return IdiomaE;	}
	
	// METODOS GET DE IDIOMA DE ENTRADA 
	
//	public String getLinea() 		{	return Linea;	}
	
//	public String[] getLineaE()		{	return LineaE;	}	
	
	public String getAgendaE() 		{	return AgendaE;	}
	
	public String getLunesE() 		{	return LunesE;	}
	public String getMartesE() 		{	return MartesE;	}
	public String getMiercolesE() 	{	return MiercolesE;	}	
	public String getJuevesE() 		{	return JuevesE;	}
	public String getViernesE() 	{	return ViernesE;	}
	public String getSabadoE() 		{	return SabadoE;	}
	public String getDomingoE() 	{	return DomingoE;}
	
	public char getLE() 			{	return LE;	}
	public char getME() 			{	return ME;	}
	public char getXE() 			{	return XE;	}
	public char getJE() 			{	return JE;	}
	public char getVE() 			{	return VE;	}
	public char getSE() 			{	return SE;	}
	public char getDE() 			{	return DE;	}	

	public String getEneroE() 		{	return EneroE;	}
	public String getFebreroE() 	{	return FebreroE;}
	public String getMarzoE() 		{	return MarzoE;	}
	public String getAbrilE() 		{	return AbrilE;	}
	public String getMayoE() 		{	return MayoE;	}
	public String getJunioE() 		{	return JunioE;	}
	public String getJulioE() 		{	return JulioE;	}
	public String getAgostoE() 		{	return AgostoE;	}
	public String getSeptiembreE()  {	return SeptiembreE;	}
	public String getOctubreE() 	{	return OctubreE;}
	public String getNoviembreE() 	{	return NoviembreE;	}
	public String getDiciembreE() 	{	return DiciembreE;	}

	public String getDiaE() 		{	return DiaE;	}
	public String getMesE() 		{	return MesE;	}
	public String getAnyE() 		{	return AnyE;	}
	public String getSemE() 		{	return SemE;	}

	public String getCerradoE() 	{	return CerradoE;	}

	public String getGeneradoE() 	{	return GeneradoE;	}
	

	 // METODOS GET PARA IDIOMA SALIDA 
		
//	public String[] getLineaS() 	{	return LineaS;	}
	
	public String getAgendaS() 		{	return AgendaS;	}

	public String getLunesS() 		{	return LunesS;	}
	public String getMartesS() 		{	return MartesS;	}
	public String getMiercolesS() 	{	return MiercolesS;	}
	public String getJuevesS() 		{	return JuevesS;	}
	public String getViernesS() 	{	return ViernesS;}
	public String getSabadoS() 		{	return SabadoS;	}
	public String getDomingoS() 	{	return DomingoS;}

	public char getLS() {	return LS;	}
	public char getMS() {	return MS;	}
	public char getXS() {	return XS;	}
	public char getJS() {	return JS;	}
	public char getVS() {	return VS;	}
	public char getSS() {	return SS;	}
	public char getDS() {	return DS;	}

	public String getEneroS() 	{	return EneroS;	}
	public String getFebreroS() {	return FebreroS;}
	public String getMarzoS() 	{	return MarzoS;	}
	public String getAbrilS() 	{	return AbrilS;	}
	public String getMayoS() 	{	return MayoS;	}
	public String getJunioS() 	{	return JunioS;	}
	public String getJulioS() 	{	return JulioS;	}
	public String getAgostoS() 	{	return AgostoS;	}
	public String getSeptiembreS()  {	return SeptiembreS;	}
	public String getOctubreS() 	{	return OctubreS;	}
	public String getNoviembreS() 	{	return NoviembreS;	}
	public String getDiciembreS() 	{	return DiciembreS;	}

	public String getDiaS() {	return DiaS;	}

	public String getMesS() {	return MesS;	}
	public String getAnyS() {	return AnyS;	}
	public String getSemS() {	return SemS;	}
	public String getCerradoS() {	return CerradoS;	}

	public String getGeneradoS() {	return GeneradoS;	}
	
	public LeerFichero getIdiomaS() {	return IdiomaS;	}
	
	

	public AplicarIdiomas (String idEntrada, String idSalida) throws Exception
	{
		this.IdiomaE = new LeerFichero("internacional."+idEntrada);
		this.IdiomaE.getLista();
		this.Rellenar_Campos_Entrada();
		this.IdiomaS = new LeerFichero("internacional."+idSalida);
		this.IdiomaS.getLista();		
		this.Rellenar_Campos_Salida();
	}
	
	
	public void Rellenar_Campos_Entrada ()
	{
		String preparadaParaSplit = "";		
		for (String linea : IdiomaE.getLista()) {
			preparadaParaSplit += linea;
		}						
		LineaE  = preparadaParaSplit.split(";");
		Linea = LineaE[1];
		LineaE  = Linea.split("00");
		AgendaE = LineaE[0];
		
			
		LineaE  = preparadaParaSplit.split(";");
		Linea = LineaE[2];
		LineaE  = Linea.split(",");		
		LunesE       = LineaE[0];
		MartesE      = LineaE[1];
		MiercolesE	 = LineaE[2];
		JuevesE		 = LineaE[3];
		ViernesE	 = LineaE[4];
		SabadoE		 = LineaE[5];
		DomingoE	 = LineaE[6];
		LineaE		 = DomingoE.split("00");
		DomingoE	 = LineaE[0];
		
		LineaE  = preparadaParaSplit.split(";");
		Linea = LineaE[4];
		LineaE  = Linea.split(",");				
		EneroE		=LineaE[0];
		FebreroE	=LineaE[1];
		MarzoE		=LineaE[2];
		AbrilE		=LineaE[3];
		MayoE		=LineaE[4];
		JunioE		=LineaE[5];
		JulioE		=LineaE[6];
		AgostoE		=LineaE[7];
		SeptiembreE	=LineaE[8];
		OctubreE	=LineaE[9];
		NoviembreE	=LineaE[10];
		DiciembreE	=LineaE[11];
		LineaE		 = DiciembreE.split("00");
		DiciembreE	 = LineaE[0];
	
		
		LineaE  = preparadaParaSplit.split(";");
		Linea = LineaE[5];
		LineaE  = Linea.split(",");				
		AnyE	=LineaE[0];
		MesE	=LineaE[1];
		SemE	=LineaE[2];
		DiaE	=LineaE[3];
		LineaE	= DiaE.split("00");
		DiaE	= LineaE[0];
		
		LineaE  = preparadaParaSplit.split(";");
		Linea = LineaE[6];
		LineaE  = Linea.split("00");
		GeneradoE = LineaE[0];
			
		LineaE   = preparadaParaSplit.split(";");
		Linea  = LineaE[7];
		LineaE 	 = Linea.split(",");				
		CerradoE = LineaE[0];
		LineaE	 = CerradoE.split("00");
		CerradoE= LineaE[0];
				
		LineaE   = preparadaParaSplit.split(";");
		Linea  = LineaE[3];		
		
		LE = Linea.charAt(0);		
		ME	=Linea.charAt(1);
		XE	=Linea.charAt(2);
		JE	=Linea.charAt(3);
		VE	=Linea.charAt(4);
		SE	=Linea.charAt(5);
		DE	=Linea.charAt(6);
			
	}
	
	
	public void Rellenar_Campos_Salida ()
	{	
		String preparadaParaSplit = "";		
		for (String linea : IdiomaS.getLista()) {
			preparadaParaSplit += linea;
		}				
		
		LineaS  = preparadaParaSplit.split(";");
		Linea = LineaS[1];
		LineaS  = Linea.split("00");
		AgendaS = LineaS[0];
		
			
		LineaS  = preparadaParaSplit.split(";");
		Linea = LineaS[2];
		LineaS  = Linea.split(",");		
		LunesS       = LineaS[0];
		MartesS      = LineaS[1];
		MiercolesS	 = LineaS[2];
		JuevesS		 = LineaS[3];
		ViernesS	 = LineaS[4];
		SabadoS		 = LineaS[5];
		DomingoS	 = LineaS[6];
		LineaS		 = DomingoS.split("00");
		DomingoS	 = LineaS[0];
		
		LineaS  	= preparadaParaSplit.split(";");
		Linea 		= LineaS[4];
		LineaS  	= Linea.split(",");				
		EneroS		=LineaS[0];
		FebreroS	=LineaS[1];
		MarzoS		=LineaS[2];
		AbrilS		=LineaS[3];
		MayoS		=LineaS[4];
		JunioS		=LineaS[5];
		JulioS		=LineaS[6];
		AgostoS		=LineaS[7];
		SeptiembreS	=LineaS[8];
		OctubreS	=LineaS[9];
		NoviembreS	=LineaS[10];
		DiciembreS	=LineaS[11];
		LineaS		= DiciembreS.split("00");
		DiciembreS	= LineaS[0];
	
		
		LineaS  = preparadaParaSplit.split(";");
		Linea 	= LineaS[5];
		LineaS  = Linea.split(",");				
		AnyS	=LineaS[0];
		MesS	=LineaS[1];
		SemS	=LineaS[2];
		DiaS	=LineaS[3];
		LineaS	= DiaS.split("00");
		DiaS	= LineaS[0];
		
		LineaS  = preparadaParaSplit.split(";");
		Linea = LineaS[6];
		LineaS  = Linea.split("00");
		GeneradoS = LineaS[0];
			
		LineaS   = preparadaParaSplit.split(";");
		Linea  = LineaS[7];
		LineaS 	 = Linea.split(",");				
		CerradoS = LineaS[0];
		LineaS	 = CerradoS.split("00");
		CerradoS= LineaS[0];
		
		
		LineaS   = preparadaParaSplit.split(";");
		Linea  = LineaS[3];		
		
		LS = Linea.charAt(0);		
		MS	=Linea.charAt(1);
		XS	=Linea.charAt(2);
		JS	=Linea.charAt(3);
		VS	=Linea.charAt(4);
		SS	=Linea.charAt(5);
		DS	=Linea.charAt(6);
			
	}	
	
	/*public static void main(String[] args)	{
		try {
			
			AplicarIdiomas idioma = new AplicarIdiomas ("CAT", "ENG");		
			
		/*	idioma.Rellenar_Campos_Entrada ();
			idioma.Rellenar_Campos_Salida ();
			
		*//*	System.out.println(idioma.getAgendaE());	
			System.out.println(idioma.getAgendaS());	
			System.out.println(idioma.getCerradoE());	
			System.out.println(idioma.getCerradoS());	
			System.out.println(idioma.getGeneradoE());
			System.out.println(idioma.getGeneradoS());
			System.out.println(idioma.getLunesE()+"-"+idioma.getMartesE()+"-"+idioma.getMiercolesE()+"-"+idioma.getJuevesE()+"-"+idioma.getViernesE()+"-"+idioma.getSabadoE()+"-"+idioma.getDomingoE());	
			System.out.println(idioma.getLunesS()+"-"+idioma.getMartesS()+"-"+idioma.getMiercolesS()+"-"+idioma.getJuevesS()+"-"+idioma.getViernesS()+"-"+idioma.getSabadoS()+"-"+idioma.getDomingoS());	
			System.out.println(idioma.getEneroE()+"-"+idioma.getFebreroE()+"-"+idioma.getMarzoE()+"-"+idioma.getAbrilE()+"-"+idioma.getMayoE()+"-"+idioma.getJunioE()+"-"+idioma.getJulioE()+"-"+idioma.getAgostoE()+"-"+idioma.getSeptiembreE()+"-"+idioma.getOctubreE()+"-"+idioma.getNoviembreE()+"-"+idioma.getDiciembreE());
			System.out.println(idioma.getEneroS()+"-"+idioma.getFebreroS()+"-"+idioma.getMarzoS()+"-"+idioma.getAbrilS()+"-"+idioma.getMayoS()+"-"+idioma.getJunioS()+"-"+idioma.getJulioS()+"-"+idioma.getAgostoS()+"-"+idioma.getSeptiembreS()+"-"+idioma.getOctubreS()+"-"+idioma.getNoviembreS()+"-"+idioma.getDiciembreS());
			System.out.println(idioma.getAnyE()+"-"+idioma.getMesE()+"-"+idioma.getSemE()+"-"+idioma.getDiaE());	
			System.out.println(idioma.getAnyS()+"-"+idioma.getMesS()+"-"+idioma.getSemS()+"-"+idioma.getDiaS());	
			System.out.println(idioma.getLE()+"-"+idioma.getME()+"-"+idioma.getXE()+"-"+idioma.getJE()+"-"+idioma.getVE()+"-"+idioma.getSE()+"-"+idioma.getDE());	
			System.out.println(idioma.getLS()+"-"+idioma.getMS()+"-"+idioma.getXS()+"-"+idioma.getJS()+"-"+idioma.getVS()+"-"+idioma.getSS()+"-"+idioma.getDS());	
					}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/


	

}