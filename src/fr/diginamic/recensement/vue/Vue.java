package fr.diginamic.recensement.vue;

import java.util.ArrayList;

import fr.diginamic.recensement.model.Departement;
import fr.diginamic.recensement.model.Ville;

/**
 * Classe chargée des affichages de l'application
 * 
 * @author jacques granarolo
 */
public class Vue {
	
	public Vue() {
		
	}

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
		} 
		else {

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
		System.out.println("\n  Saisir votre choix et validez :");
	}

	public void displayLoadDataMenu() {
		System.out.println("\n\n\n\n");
		System.out.println("  *********************************************");
		System.out.println("  *                                           *");
		System.out.println("  * Recensement                               *");
		System.out.println("  *                                           *");
		System.out.println("  * Chargement des données depuis             *");
		System.out.println("  * le fichier .csv                           *");
		System.out.println("  *                                           *");
		System.out.println("  *********************************************");
	}
	
	public void displayMenu01() {
		System.out.println("\n\n\n\n");
		System.out.println("  *********************************************");
		System.out.println("  *                                           *");
		System.out.println("  * Recensement                               *");
		System.out.println("  *                                           *");
		System.out.println("  * Saisissez le nom d'une ville :            *");
		System.out.println("  *                                           *");
		System.out.println("  *********************************************");
	}
	
	public void displayMenu02() {
		System.out.println("\n\n\n\n");
		System.out.println("  *********************************************");
		System.out.println("  *                                           *");
		System.out.println("  * Recensement                               *");
		System.out.println("  *                                           *");
		System.out.println("  * Saisissez le code d'un département :      *");
		System.out.println("  *                                           *");
		System.out.println("  *********************************************");
		
	}

	public void displayContinue() {
		System.out.println("\n  'C' pour continuer :");
	}

	public void displayInfosDatas(ArrayList<Ville> listVilles) {
		System.out.println("\n  Nombre de villes dans la liste : " + listVilles.size());
		
	}

	public void displayVilleNotFound(String nom) {
		System.out.println("\n  Pas de ville à ce nom : " + nom);
	}

	public void displayVille(Ville ville) {
		System.out.println("\n  Nom : " + ville.getNomCom() + " / population : " + ville.getPopulTotale() + " habitants");
	}

	public void displayDeptNotFound(String codeDpt) {
		System.out.println("\n  Pas de département avec ce code : " + codeDpt);
	}

	public void displayPopDept(Departement dept) {
		System.out.println("\n  Code du département : " + dept.getCodeDept() + " / population : " + dept.getPopulTotale());
	}


}
