package negocio; 
import java.io.FileNotFoundException; 
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
	private LeerFicheroConfig Conf;
	private AplicarIdiomas Idiomas;
	
	
	
	
	
	public void bodyTable(int dSemana, int dPrincipio, int dFinal, String[][] tHoras)
	{

		
		String aux = "";
			this.lista.add( "<TR border = \"1\">" + 
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\"  > " + this.Idiomas.getSemS() + " " 
							+ QueSemana(dPrincipio) + " </TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getLS() +
										"</TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getMS() +
										"</TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getXS() +
										"</TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getJS() +
										"</TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getVS() +
										"</TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getSS() +
										"</TD>" +
							"<TD width=\"10%\" bgcolor=\"#F0E8AA\" >"
							+ Idiomas.getDS() +
										"</TD> </TR>" 
					); 
			for(int linea = 0; linea <= 23; linea++ )
			{
				this.lista.add("<TR>");
				this.lista.add( "<TD bgcolor=\"#F0E8AA\" >" + linea + " - " + (linea +1) + "</TD>");
				if (dSemana == 0 )
				{
					//for (int columna=0 ; columna< 7; columna++)
					for (int i = dPrincipio-1  ; i <= (dFinal-1); i ++)
					{
						aux = "<TD";
						if ((i) < tHoras[linea].length)
						{
							if ((tHoras[linea][i] == null)  )//si esa hora es activa
							{
								aux += " bgcolor=\"#363640\"> </TD>";
							} //
							else
							{	
							aux +="  bgcolor=\"#E9EEF1\" align=\"center\" >" + tHoras[linea][i] + "</TD>";
								
							}
						}
						else
						{
							aux += " bgcolor=\"#363640\"> </TD>";
						}
						this.lista.add(aux);
						
					}
				}
				else
				{
					for (int columna=0 ; columna < dSemana; columna++)
					{
						aux = "<TD bgcolor=\"#363640\"> </TD>";
						this.lista.add(aux);
					}
					for (int columna=dSemana ; columna< 7; columna++)
					{
						aux = "<TD";
						if ((dPrincipio + columna-dSemana - 1) < tHoras[linea].length)
						{
							if ((tHoras[linea][dPrincipio + columna-dSemana - 1] == null)  )//si esa hora es activa
							{
								aux += " bgcolor=\"#363640\"> </TD>";
							} //
							else
							{	
							aux +="  bgcolor=\"#E9EEF1\" align=\"center\" >" + tHoras[linea][dPrincipio + columna-dSemana - 1] + "</TD>";
								
							}
						}
						else
						{
							aux += " bgcolor=\"#363640\"> </TD>";
						}
						this.lista.add(aux);
					}
					
				}
			
				this.lista.add("</TR>");
			}
	        
	   
		
		
	
	}
	
	
	

	public void bodyHTML()
	{
		int semanas = semanasMes();
		int dia1 = diaSemana(1);
		String recurso;
		String[][] tHoras;
		
		
		for (Entry<String, String[][]> e: horarios.entrySet()) {
			
			recurso = e.getKey().toString();
			this.lista.add("<div align=\"center\" >");
			this.lista.add("<B >" + recurso + "</B>" + "<BR/><BR/><BR/>");
			
			tHoras = e.getValue();
			
		int semana, semBegin, dPrincipio, dFin, cont, dSemana;
		dFin = setMaxDias(this.mes, this.anyo);
		semana = semBegin = QueSemana(1);
		dPrincipio = cont = 1;
		while (cont < dFin)
		{

			while (semana == semBegin)
			{
				cont += 1;
				semana = QueSemana(cont);
				
			}
			dSemana = diaSemana(dPrincipio);
			headerTable(recurso);
			bodyTable(dSemana, dPrincipio, cont -1 , tHoras);
			footerTable();
			dPrincipio = cont;
			semBegin = semana;		
		}	
			
		this.lista.add("</div>");
			
			
		}
	}
	
	
	public void buildAgenda() throws Exception
	{
		headerHTML();
		bodyHTML();
		footerHTML();
		super.aDisco(this.lista);
		
	}
	
	
	
	public void headerHTML () throws Exception
	{
		this.lista.add("<html>");
		this.lista.add("<head>");
		this.lista.add("<title>" + this.Idiomas.getAgendaS() + "</title>"   );
		this.lista.add("<BR/>");
		this.lista.add("<title>" + util.Utiles.Mes_de_Salida(this.Conf) + " " + this.anyo + "</title>"   );
		this.lista.add("</head>");
		this.lista.add("<body>");
		
		
	}
	public void footerHTML ()
	{
		this.lista.add("</table>");
		this.lista.add("</body>");
		this.lista.add("</html>");
		
	}
	
	
	
	public void headerTable (String cabecera )
	{
		
		this.lista.add("<TABLE align=\"center\" width=\"80%\">");
				
	}
	public void footerTable ()
	{
		this.lista.add("</TABLE>");
		this.lista.add("<BR/>");this.lista.add("<BR/>");
	}
	
	
	//Builder
	public EscribeHTML(HashMap<String, String [][]> horarios , String nombreArchivo, LeerFicheroConfig conf) throws Exception {		
			super(nombreArchivo);
			this.Conf = conf;
			this.Idiomas = new AplicarIdiomas(Conf.getIdiomaE(),Conf.getIdiomaS());
			this.horarios = horarios;
			this.mes = Conf.getMes() -1;
			this.anyo = Conf.getAny();
			
			
		}
	
	
	
	//Privadas
	private int QueSemana (int dia){
		Calendar  ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, dia);		
		ca.set(Calendar.MONTH, this.mes);
		ca.set(Calendar.YEAR, this.anyo);
		ca.setMinimalDaysInFirstWeek(1);
		
		
		
		return ca.get(Calendar.WEEK_OF_YEAR); 
	}
	private int semanasMes (){
		Calendar  ca = Calendar.getInstance();
		ca.set(Calendar.MONTH, this.mes);
		ca.set(Calendar.YEAR, this.anyo);
		int ultimo = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
		ca.set(Calendar.DAY_OF_MONTH, ultimo);
		ca.setMinimalDaysInFirstWeek(1);
		//instanciando el ultimo día sabemos el número de semanas del mes
		return ca.get(Calendar.WEEK_OF_MONTH); //la primera semana es 1 no 0
	}
	
	
	private int numSemana (int dia){
		Calendar  ca = Calendar.getInstance();
		ca.setFirstDayOfWeek(2);
		ca.setMinimalDaysInFirstWeek(1);

		ca.set(Calendar.DAY_OF_MONTH, dia);
		ca.set(Calendar.MONTH, this.mes);
		ca.set(Calendar.YEAR, this.anyo);
		return ca.get(Calendar.WEEK_OF_YEAR);
	}
	
	private int setMaxDias(int mes, int anyo){
		Calendar ca = Calendar.getInstance();
		ca.setMinimalDaysInFirstWeek(1);
		ca.set(Calendar.MONTH, mes );
		ca.set(Calendar.YEAR, anyo);
		return ca.getActualMaximum(Calendar.DAY_OF_MONTH);
	} 
	
	private int diaSemana (int diaS){
		Calendar  ca = Calendar.getInstance();
//		ca.setFirstDayOfWeek(2);
		ca.set(Calendar.DAY_OF_MONTH, diaS);
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



