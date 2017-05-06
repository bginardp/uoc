package es.uoc.precintes.utils;

import java.util.Date;

public class ModelUtils {
  public static final String DEFAULTENTITAT="JUDI";
  public static final String ERROR_RANG_DATES_KEY="error.rangdates.invalid";
  public static final String ERROR_DATA_DESPRECINTE_KEY="error.datadesprecinte.invalid";
  public static final String ERROR_DATA_MAJORACTUAL_KEY="error.datamajoractual.invalid";
  public static final String ERROR_MOTIU_DESPRECINTE_OBLIGATORI_KEY="error.motiusdesprecinte.obligatori";

  
  public static final int DIES_DESDE_DEFECTE=-3000;
  
  public static boolean beforeThat(Date date1, Date date2) {
	  return date1==null||date2==null?true:date2.before(date1);
  }
  
  public static boolean afterThat(Date date1, Date date2) {
	  return date1==null||date2==null?false:date1.after(date2);
  }
  
  public static boolean equalsThat(Date date1, Date date2) {
	  return date1==null||date2==null?false:date1.equals(date2);
  }
}
