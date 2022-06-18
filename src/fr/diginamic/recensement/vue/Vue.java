package fr.diginamic.recensement.vue;

public class Vue {


	public void displayGeneralMenu(boolean isFileLoaded) {
		System.out.println("\n\n\n\n");
		System.out.println("  *********************************************");
		System.out.println("  *                                           *");
		System.out.println("  * Recensement                               *");
		System.out.println("  *                                           *");
		System.out.println("  * Menu :                                    *");
		System.out.println("  *                                           *");
		if (!isFileLoaded) {
			System.out.println("  * 0 : Initialisation des données            *");
		} else {

			System.out.println("  * 1 : Population d'une ville                *");
			System.out.println("  * 2 : Population d'un département           *");
			System.out.println("  * 3 : Population d'une région               *");
			System.out.println("  * 4 : Les dix régions les plus peuplées     *");
			System.out.println("  * 5 : Les dix départements les plus peuplés *");
			System.out.println("  * 6 : Les dix villes les plus peuplées      *");
			System.out.println("  *     d'un département                      *");
			System.out.println("  * 7 : Les dix villes les plus peuplées      *");
			System.out.println("  *     d'une région                          *");
			System.out.println("  * 8 : Les dix villes les plus peuplées      *");
			System.out.println("  *     de France                             *");
		}
		System.out.println("  * Q : quitter l'application                 *");
		System.out.println("  *                                           *");
		System.out.println("  *********************************************");
		System.out.println("\n\n  Saisir votre choix et validez :");
	}

}
