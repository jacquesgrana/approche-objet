package fr.diginamic.recensement.vue;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import fr.diginamic.recensement.model.Departement;
import fr.diginamic.recensement.model.Region;
import fr.diginamic.recensement.model.ToolsForFormatting;
import fr.diginamic.recensement.model.Ville;

/**
 * Classe chargée des affichages de l'application
 * 
 * @author jacques granarolo
 */
public class Vue {
	
	/**
	 * Constructeur
	 */
	public Vue() {
		
	}

	/**
	 * Méthode qui affiche le menu principal selon si les données ont été chargées ou pas
	 * en fonction du booléen isFileLoaded. 
	 * 
	 * @param isFileLoaded : booléen qui indique si le fichier .csv a été chargé ou pas
	 */
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

	/**
	 * Méthode qui affiche le menu du choix 0. 
	 */
	public void displayMenu00() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Chargement des données depuis              *");
		System.out.println("  * les fichiers .csv                          *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	/**
	 * Méthode qui affiche le menu du choix 1. 
	 */
	public void displayMenu01() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Affiche la population d'une ville          *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisissez le nom :                         *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	/**
	 * Méthode qui affiche le menu du choix 2. 
	 */
	public void displayMenu02() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Affiche la population d'un département     *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisissez le code :                        *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");
	}
	
	/**
	 * Méthode qui affiche le menu du choix 3. 
	 */
	public void displayMenu03() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Affiche la population d'une région         *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisissez le code :                        *");
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
	
	/**
	 * Méthode qui affiche le menu du choix 4. 
	 */
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
	
	/**
	 * Méthode qui affiche le menu du choix 5. 
	 */
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
	
	/**
	 * Méthode qui affiche le menu du choix 6. 
	 */
	public void displayMenu06() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Top 10 des Villes les plus peuplés         *");
		System.out.println("  * pour un département                        *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisir le code du département :            *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");	
	}
	
	/**
	 * Méthode qui affiche le menu du choix 7. 
	 */
	public void displayMenu07() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Top 10 des Villes les plus peuplés         *");
		System.out.println("  * pour une région                            *");
		System.out.println("  *                                            *");
		System.out.println("  * Saisir le code de la région :              *");
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
	
	/**
	 * Méthode qui affiche le menu du choix 8. 
	 */
	public void displayMenu08() {
		System.out.println("\n\n\n\n");
		System.out.println("  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  * Recensement                                *");
		System.out.println("  *                                            *");
		System.out.println("  * Top 10 des Villes les plus peuplés         *");
		System.out.println("  * de France :                                *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************");	
	}

	/**
	 * Méthode qui affiche 'C' pour continuer
	 */
	public void displayContinue() {
		System.out.println("\n  'C' pour continuer :");
	}

	/**
	 * Méthode qui affiche le nombre de villes de la liste des villes, 
	 * le nombre de départements de la liste des départements 
	 * et le nombre de régions de la liste des régions. 
	 * 
	 * @param listVilles : liste des villes
	 * @param listDept : liste des départements
	 * @param listRegion : liste des régions
	 */
	public void displayInfosDatas(ArrayList<Ville> listVilles, ArrayList<Departement> listDept, ArrayList<Region> listRegion) {
		System.out.println("\n  Nombre de communes récupérées dans la liste : " + listVilles.size());
		System.out.println("  Nombre de départements récupérés dans la liste : " + listDept.size());
		System.out.println("  Nombre de régions récupérées dans la liste : " + listRegion.size());
	}

	/**
	 * Méthode qui affiche 'Pas de ville à ce nom' et le nom choisi. 
	 * 
	 * @param nom : nom choisi
	 */
	public void displayVilleNotFound(String nom) {
		System.out.println("\n  Pas de ville à ce nom : " + nom);
	}

	/**
	 * Méthode qui affiche 'Pas de département avec ce code' et le code choisi. 
	 * 
	 * @param codeDpt : code choisi
	 */
	public void displayDeptNotFound(String codeDpt) {
		System.out.println("\n  Pas de département avec ce code : " + codeDpt);
	}
	
	/**
	 * Méthode qui affiche 'Pas de région avec ce code' et le code choisi. 
	 * 
	 * @param codeRegion : code choisi
	 */
	public void displayRegionNotFound(String codeRegion) {
		System.out.println("\n  Pas de région avec ce code : " + codeRegion);
	}
	
	/**
	 * Méthode qui affiche les infos d'une ville. 
	 * 
	 * @param ville : ville à afficher
	 */
	
	public void displayVille(Ville ville) {
		System.out.println("\n  Nom : " + ville.getNomCom() + " / population : " + NumberFormat.getInstance(Locale.FRANCE).format(ville.getPopulTotale()) + " habitants");
	}

	/**
	 * Méthode qui affiche les infos d'un département. 
	 * 
	 * @param dept : département à afficher
	 */
	public void displayDept(Departement dept) {
		System.out.println("\n  Code : " + dept.getCodeDept()  + " / nom : " + dept.getNomDept() + " / population : " + NumberFormat.getInstance(Locale.FRANCE).format(dept.getPopulTotale()) + " habitants");
	}

	/**
	 * Méthode qui affiche les infos d'une région. 
	 * 
	 * @param region : région à afficher
	 */
	public void displayRegion(Region region) {
		System.out.println("\n  Code : " + region.getCodeRegion() + " / nom : " + region.getNomRegion() + " / population : " + NumberFormat.getInstance(Locale.FRANCE).format(region.getPopulTotale()) + " habitants");
	}

	/**
	 * Méthode qui affiche les dix premiers éléments de la liste des régions. 
	 *  
	 * @param listRegion : liste à afficher
	 */
	public void displayTopTenRegionList(ArrayList<Region> listRegion) {
		int cpt = 1;
		System.out.println();
		for(Region region : listRegion) {
			if (cpt <= 10) {
				ToolsForFormatting.AlignLeft(30, "  " + region.getNomRegion());
				System.out.println(": " + NumberFormat.getInstance(Locale.FRANCE).format(region.getPopulTotale()) + " habitants");
			}
			else {
				break;
			}
			cpt++;
		}
	}
	
	/**
	 * Méthode qui affiche les dix premiers éléments de la liste des départements. 
	 *  
	 * @param listDept : liste à afficher
	 */
	public void displayTopTenDeptList(ArrayList<Departement> listDept) {
		int cpt = 1;
		System.out.println();
		for(Departement dept : listDept) {
			if (cpt <= 10) {
				ToolsForFormatting.AlignLeft(30, "  " + dept.getNomDept());
				System.out.println(": " + NumberFormat.getInstance(Locale.FRANCE).format(dept.getPopulTotale()) + " habitants");
			}
			else {
				break;
			}
			cpt++;
		}
	}
	
	/**
	 * Méthode qui affiche les dix premiers éléments de la liste des villes. 
	 *  
	 * @param listToDisplay : liste à afficher
	 */
	public void displayTopTenVilleList(ArrayList<Ville> listToDisplay) {
		int cpt = 1;
		System.out.println();
		for(Ville ville : listToDisplay) {
			if (cpt <= 10) {
				ToolsForFormatting.AlignLeft(30, "  " + ville.getNomCom());
				System.out.println( ": " + NumberFormat.getInstance(Locale.FRANCE).format(ville.getPopulTotale()) + " habitants");
			}
			else {
				break;
			}
			cpt++;
		}
	}

	/**
	 * Méthode qui affiche les infos d'un département. 
	 * 
	 * @param deptToDisplay : département à afficher
	 */
	public void displayDeptInfos(Departement deptToDisplay) {
		System.out.println("\n  Département choisi : code : " + deptToDisplay.getCodeDept() + " / nom : " + deptToDisplay.getNomDept());
	}

	/**
	 * Méthode qui affiche les infos d'une région
	 * 
	 * @param regionToDisplay : région à afficher
	 */
	public void displayRegionInfos(Region regionToDisplay) {
		System.out.println("\n  Région choisie : code : " + regionToDisplay.getCodeRegion() + " / nom : " + regionToDisplay.getNomRegion());
	}

	/**
	 * Méthode qui affiche le message de fin de l'application. 
	 */
	public void displayAppEnd() {
		System.out.println("\n  Fin du programme");
	}

	/**
	 * Méthode qui affiche le message de l'exception IOException. 
	 * 
	 * @param e : exception levée de type  IOException
	 */
	public void displayIOErrorMessage(IOException e) {
		System.out.println("\n  Erreur pendant le chargement du fichier .csv : message : " + e.getMessage());
	}

	/**
	 * Méthode qui affiche un message dans le cas où le chargement du fichier .csv n'est pas possible. 
	 */
	public void displayCSVNotLoaded() {
		System.out.println("\n  Fichier .csv non chargé");
	}

}
