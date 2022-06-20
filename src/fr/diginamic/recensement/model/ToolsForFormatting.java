package fr.diginamic.recensement.model;

//ToolsForFormatting.java - version allégée
//Version 2.2 • Dernière mise à jour le 24 oct. 2015.
//Copyright (c) 2012 - 2015 Christophe Marty. All rights reserved.

/**
 * Classe contenant deux méthodes public static qui aident pour l'affichage en console.
 * Une pour "aligner" le texte à gauche, 
 * une autre pour "aligner" le texte à droite. 
 * Classe copiée et allégée pour le TP16.  
 */
public class ToolsForFormatting {
	
	/**
	 * Méthode qui affiche un espace. 
	 */
	static void printSpace()
	{
		System.out.print(" ");
		return;
	}

	/**
	 * Méthode qui affiche n espaces.
	 * 
	 * @param n : nombre d'espaces à afficher
	 */
	static void printNSpaces(int n)
	{
		while(n >= 10)
		{
			System.out.print("          ");
			n -= 10;
		}
		while(n >= 2)
		{
			System.out.print("  ");
			n -= 2;
		}
		while(n > 0)
		{
			System.out.printf(" ");
			n--;
		}
		return;
	}
	
	/**
	 * Méthode qui calcule le nombre de caractères entre la longueur voulue et la longueur du texte.
	 * 
	 * @param TotalLength : longueur voulue
	 * @param TextLength : longueur du texte
	 * @return nombre de caractères
	 */
	static int calcNbrOfSpaces(int TotalLength, int TextLength)
	{
		if(TextLength > TotalLength)
			return 0;
		return TotalLength - TextLength;
	}
	
	/**
	 * Méthode qui affiche une chaine qui se termine par des espaces pour avoir la longueur fixés par totalLength. 
	 * 
	 * @param totalLength : taille de la chaine affichée
	 * @param Text : texte à afficher à gauche
	 */
	public static void alignLeft(int totalLength, String Text)
	{
		System.out.print(Text);
		if (Text != null) {
			printNSpaces(calcNbrOfSpaces(totalLength, Text.length()));
			return;
		}
		else {
			printNSpaces(calcNbrOfSpaces(totalLength, 4));
			return;
		}
	}
	
	/**
	 * Méthode qui affiche une chaine qui se commence par des espaces pour avoir la longueur fixés par totalLength. 
	 * 
	 * @param totalLength : taille de la chaine affichée
	 * @param Text : texte à afficher à droite
	 */
	public static void alignRight(int totalLength, String Text)
	{
		printNSpaces(calcNbrOfSpaces(totalLength, Text.length()));
		System.out.print(Text);
		return;
	}
}