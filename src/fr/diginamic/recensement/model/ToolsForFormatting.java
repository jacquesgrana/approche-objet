package fr.diginamic.recensement.model;

//ToolsForFormatting.java
//Version 2.2 • Dernière mise à jour le 24 oct. 2015.
//Copyright (c) 2012 - 2015 Christophe Marty. All rights reserved.
// version allégée pour le TP16

public class ToolsForFormatting {
	// Affiche une espace.
	static void PrintSpace()
	{
		System.out.print(" ");
		return;
	}

	// Afficher n espaces.
	static void PrintNSpaces(int n)
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

	// Calcule le nombre d'espaces entre la longueur voulue et la longueur du texte.
	static int CalcNbrOfSpaces(int TotalLength, int TextLength)
	{
		if(TextLength > TotalLength)
			return 0;
		return TotalLength - TextLength;
	}

	// Aligne le texte à gauche et complète avec des espaces.
	public static void AlignLeft(int TotalLength, String Text)
	{
		System.out.print(Text);
		if (Text != null) {
			PrintNSpaces(CalcNbrOfSpaces(TotalLength, Text.length()));
			return;
		}
		else {
			PrintNSpaces(CalcNbrOfSpaces(TotalLength, 4));
			return;
		}
		
	}

	// Aligne le texte à droite et complète avec des espaces.
	public static void AlignRight(int TotalLength, String Text)
	{
		PrintNSpaces(CalcNbrOfSpaces(TotalLength, Text.length()));
		System.out.print(Text);
		return;
	}

}