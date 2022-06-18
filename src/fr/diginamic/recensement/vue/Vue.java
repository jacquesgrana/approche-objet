package fr.diginamic.recensement.vue;

import java.util.ArrayList;

import fr.diginamic.recensement.model.Departement;
import fr.diginamic.recensement.model.Region;
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
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Menu :                                     *");
		System.out.println("  *                                            *");
		if (!isFileLoaded) {
			System.out.println("  * 0 : Initialisation des données             *");
		} 
		else {

			System.out.println("  * 1 : Population d'une ville                 *");
			System.out.println("  * 2 : Population d'un département            *");
			System.out.println("  * 3 : Population d'une région                *");
			System.out.println("  * 4 : Les dix régions les plus peuplées      *");
			System.out.println("  * 5 : Les dix départements les plus peuplés  *");
			System.out.println("  * 6 : Les dix villes les plus peuplées       *");
			System.out.println("  *     d'un département                       *");
			System.out.println("  * 7 : Les dix villes les plus peuplées       *");
			System.out.println("  *     d'une région                           *");
			System.out.println("  * 8 : Les dix villes les plus peuplées       *");
			System.out.println("  *     de France                              *");
		}
		System.out.println("  * Q : quitter l'application                  *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
		System.out.println("\n  Saisir votre choix et validez :");
	}

	public void displayLoadDataMenu() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Chargement des données depuis              *");
		System.out.println("  * le fichier .csv                            *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	public void displayMenu01() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisissez le nom d'une ville :             *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	public void displayMenu02() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisissez le code d'un département :       *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	public void displayMenu03() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisissez le code d'une région :           *");
		System.out.println("  *                                            *");
		System.out.println("  * Auvergne Rhone Alpes : 84                  *");
		System.out.println("  * Bourgogne Franche Comté : 27               *");
		System.out.println("  * Bretagne : 53                              *");
		System.out.println("  * Centre Val de Loire : 24                   *");
		System.out.println("  * Corse : 94                                 *");
		System.out.println("  * Grand Est : 44                             *");
		System.out.println("  * Guadeloupe : 1                             *");
		System.out.println("  * Guyane : 3                                 *");
		System.out.println("  * Hauts de France : 32                       *");
		System.out.println("  * Ile de France : 11                         *");
		System.out.println("  * La Réunion : 4                             *");
		System.out.println("  * Martinique : 2                             *");
		System.out.println("  * Normandie : 28                             *");
		System.out.println("  * Nouvelle Aquitaine : 75                    *");
		System.out.println("  * Occitanie : 76                             *");
		System.out.println("  * Pays de la Loire : 52                      *");
		System.out.println("  * Provence Alpes Côte d'Azur : 93            *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	public void displayMenu04() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Top 10 des régions les plus peuplées :     *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	public void displayMenu05() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Top 10 des départements les plus peuplés : *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
		
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
	
	public void displayRegionNotFound(String codeRegion) {
		
		System.out.println("\n  Pas de région avec ce code : " + codeRegion);
	}

	public void displayPopRegion(Region region) {
		System.out.println("\n  Nom de la région : " + region.getNomRegion() + " / Code de la région : " + region.getCodeRegion() + " / population : " + region.getPopulTotale());
	}

	public void displayTopTenRegionByPop(ArrayList<Region> listRegion) {
		int cpt = 1;
		System.out.println();
		for(Region region : listRegion) {
			if (cpt <= 10) {
				System.out.println("  " + region.getNomRegion() + " : " + region.getPopulTotale() + " habitants");
			}
			cpt++;
		}
	}
	
	public void displayTopTenDeptByPop(ArrayList<Departement> listDept) {
		int cpt = 1;
		System.out.println();
		for(Departement dept : listDept) {
			if (cpt <= 10) {
				System.out.println("  " + dept.getCodeDept() + " : " + dept.getPopulTotale() + " habitants");
			}
			cpt++;
		}
	}
}
