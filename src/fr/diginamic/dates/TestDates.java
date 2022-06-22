package fr.diginamic.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDates {

	public static void main(String[] args) {
		Date date1 = new Date();
		SimpleDateFormat dtf1 = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate1 = dtf1.format(date1);
        System.out.println("\nDate du jour : " + formattedDate1);
		
		Date date2 = new Date(116, 4, 19, 23, 59, 30);
		SimpleDateFormat dtf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formattedDate2 = dtf2.format(date2);
        System.out.println("\nObjet date créé : " + formattedDate2);
	}

}
