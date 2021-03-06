package es.uoc.precintes.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ModelUtils {
  public static final String DEFAULTENTITAT="JUDI";
  public static final String ERROR_RANG_DATES_KEY="error.rangdates.invalid";
  public static final String ERROR_DATA_DESPRECINTE_KEY="error.datadesprecinte.invalid";
  public static final String ERROR_DATA_MAJORACTUAL_KEY="error.datamajoractual.invalid";
  public static final String ERROR_MOTIU_DESPRECINTE_OBLIGATORI_KEY="error.motiusdesprecinte.obligatori";
  public static final String ERROR_DATA_DESPRECINTE_OBLIGATORI_KEY="error.datadesprecinte.obligatori";
  public static final String ERROR_MATRICULA_JAEXISTEIX_KEY="error.vehicle.matricula.existeix";
  public static final String ERROR_MATRICULA_FORMAT_INVALID_KEY="error.vehicle.matricula.format.invalid";
  public static final String ERROR_BASTIDOR_JAEXISTEIX_KEY="error.vehicle.bastidor.existeix";
  public static final String ERROR_DESCONEGUT_KEY="error.descontrolat";

  
  public static final int DIES_DESDE_DEFECTE=-8000;
  
  public static boolean beforeThat(Date date1, Date date2) {
	  return date1==null||date2==null?true:date2.before(date1);
  }
  
  public static boolean afterThat(Date date1, Date date2) {
	  return date1==null||date2==null?false:date1.after(date2);
  }
  
  public static boolean equalsThat(Date date1, Date date2) {
	  return date1==null||date2==null?false:date1.equals(date2);
  }
  
  
  public static boolean matriculaValida(String input) {
	  List<Pattern> rxs = new ArrayList();
	  rxs.add(Pattern.compile("[A-Z]{2}[0-9]{4}[A-Z]{2}"));
	  rxs.add(Pattern.compile("[A-Z]\\s[0-9]{4}[A-Z]{2}"));
	  rxs.add(Pattern.compile("[A-Z]{2}[0-9]{4}\\s[A-Z]"));
	  rxs.add(Pattern.compile("[A-Z]\\s[0-9]{4}\\s[A-Z]"));
	  rxs.add(Pattern.compile("[A-Z]{2}[0-9]{6}"));
	  rxs.add(Pattern.compile("[A-Z]\\s[0-9]{6}"));
	  rxs.add(Pattern.compile("[A-Z]{2}[0-9]{5}[R]"));
	  rxs.add(Pattern.compile("[A-Z]\\s[0-9]{5}[R]"));
	  rxs.add(Pattern.compile("[A-Z]{2}[0-9]{5}[VE]"));
	  rxs.add(Pattern.compile("[A-Z]\\s[0-9]{5}[VE]"));
	  rxs.add(Pattern.compile("[0-9]{2}[A-Z]{2}[0-9]{4}"));
	  rxs.add(Pattern.compile("[0-9]{2}[A-Z]\\s[0-9]{4}"));
	  rxs.add(Pattern.compile("[A-Z][0-9]{4}[A-Z]{3}"));
	  rxs.add(Pattern.compile("[A-Z]{2}[0-9]{4}"));
	  rxs.add(Pattern.compile("[0-9]{4}[A-Z]{3}"));
	  for (Pattern rx : rxs) if (rx.matcher(input).matches()) return true;
	  return false;
  }
}
