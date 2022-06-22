package fr.diginamic.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestCalendar {

	public static void main(String[] args) {
		

        SimpleDateFormat dtfSimple = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2016, 4, 19, 23, 59, 30);
        Date dateDefinie = calendar1.getTime();
        String formattedDateDefinie = dtfSimple.format(dateDefinie);
        System.out.println("\nObjet date : " + formattedDateDefinie);
		
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date dateDuJour = calendar.getTime();
        String formattedDateduJour = dtf.format(dateDuJour);
        System.out.println("\nDate du jour : " + formattedDateduJour);
        
        SimpleDateFormat dtfFrancais = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.FRANCE);
        String formattedDateFrancais = dtfFrancais.format(dateDuJour);
        System.out.println("\nDate du jour en français : " + formattedDateFrancais);
        
        SimpleDateFormat dtfRusse = new SimpleDateFormat("EEEE dd MMMM yyyy", new Locale("ru", "RU"));
        String formattedDateRusse = dtfRusse.format(dateDuJour);
        System.out.println("\nDate du jour en russe : " + formattedDateRusse);
        
        SimpleDateFormat dtfChinois = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.CHINA);
        String formattedDateChinois = dtfChinois.format(dateDuJour);
        System.out.println("\nDate du jour en chinois : " + formattedDateChinois);
        
        SimpleDateFormat dtfAllemand = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.GERMANY);
        String formattedDateAllemand = dtfAllemand.format(dateDuJour);
        System.out.println("\nDate du jour en allemand : " + formattedDateAllemand);
	}

}
