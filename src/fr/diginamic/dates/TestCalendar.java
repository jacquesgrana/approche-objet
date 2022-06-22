package fr.diginamic.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestCalendar {

	public static void main(String[] args) {
		

        SimpleDateFormat dtf2 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2016, 4, 19, 23, 59, 30);
        Date dateObj2 = calendar2.getTime();
        String formattedDate2 = dtf2.format(dateObj2);
        System.out.println("\nObjet date : " + formattedDate2);
		
		SimpleDateFormat dtf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        Date dateObj1 = calendar1.getTime();
        String formattedDate1 = dtf1.format(dateObj1);
        System.out.println("\nDate du jour : " + formattedDate1);
        
        SimpleDateFormat dtf3 = new SimpleDateFormat("EEEE MMMM yyyy", Locale.FRANCE);
        String formattedDate3 = dtf3.format(dateObj1);
        System.out.println("\nDate du jour en français : " + formattedDate3);
        
        SimpleDateFormat dtf4 = new SimpleDateFormat("EEEE MMMM yyyy", new Locale("ru", "RU"));
        String formattedDate4 = dtf4.format(dateObj1);
        System.out.println("\nDate du jour en russe : " + formattedDate4);
        
        SimpleDateFormat dtf5 = new SimpleDateFormat("EEEE MMMM yyyy", Locale.CHINA);
        String formattedDate5 = dtf5.format(dateObj1);
        System.out.println("\nDate du jour en chinois : " + formattedDate5);
        
        SimpleDateFormat dtf6 = new SimpleDateFormat("EEEE MMMM yyyy", Locale.GERMANY);
        String formattedDate6 = dtf6.format(dateObj1);
        System.out.println("\nDate du jour en allemand : " + formattedDate6);
	}

}
