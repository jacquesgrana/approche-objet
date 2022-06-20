package fr.diginamic.recensement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import fr.diginamic.recensement.model.ComparatorDptByPopDecr;
import fr.diginamic.recensement.model.ComparatorRegionByPopDecr;
import fr.diginamic.recensement.model.ComparatorVilleByPopDecr;
import fr.diginamic.recensement.model.Departement;
import fr.diginamic.recensement.model.Model;
import fr.diginamic.recensement.model.Region;
import fr.diginamic.recensement.model.Ville;
import fr.diginamic.recensement.vue.Vue;

/**
 * Classe controlleur de l'application, utilise model et vue
 * gère les choix de l'utilisateur et appelle les méthodes correspondantes
 * 
 * Le fichier .csv a été légèrement normalisé pour Lyon : remplacement des arrondissements de Lyon par une seule ligne pour Lyon avec les totaux correspondants. 
 * Plus, utilisation du fichier .csv des départemetns de l'insee, pour pouvoir afficher les noms des départements dans l'application. 
 * 
 * @see Model
 * @see Vue
 * @see Ville
 * @see Departement
 * @see Region
 * @see ComparatorVilleByPopDecr
 * @see ComparatorDptByPopDecr
 * @see ComparatorRegionByPopDecr
 * @author jacques granarolo
 */
public class ControllerApp {

	private Model model;
	private Vue vue;

	public ControllerApp() {

	}
	
	/**
	 * Méthode qui lnitialise le controlleur. 
	 */
	public void init() {
		this.model = new Model();
		this.vue = new Vue();
		this.model.init();
	}

	/**
	 * Méthode principale du controlleur, 
	 * affiche le menu et appelle des méthodes selon les choix de l'utilisateur. 
	 */
	public void run(){
		boolean quit = false;
		char choice = 'X';
		do {
			this.vue.displayGeneralMenu(this.model.getIsFileLoaded());
			String choiceString = this.model.getScanner().next();
			choice = choiceString.charAt(0);

			switch (choice) {
			case 'Q', 'q' :
				quit = true;
			break;
			case '0' :
				if (!model.getIsFileLoaded()) {
					this.loadDatasFromCSV(this.model.getScanner());
				}
				break;
			case '1' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayVille(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			case '2' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayDeptPop(this.model.getListVilles(), this.model.getListDpts(), this.model.getScanner());
				}
				break;
			case '3' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayRegionPop(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			case '4' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayTopTenRegionPop(this.model.getListVilles(), this.model.getListRegions(), this.model.getScanner());
				}
				break;
			case '5' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayTopTenDeptPop(this.model.getListVilles(), this.model.getListDpts(), this.model.getScanner());
				}
				break;
			case '6' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayTopTenPopVilleByDept(this.model.getListVilles(), this.model.getListDpts(), this.model.getScanner());
				}
				break;
			case '7' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayTopTenPopVilleByRegion(this.model.getListVilles(), this.model.getListRegions(), this.model.getScanner());
				}
				break;
			case '8' :
				if (model.getIsFileLoaded()) {
					this.searchAndDisplayTopTenPopVilleFrance(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			}
		}
		while (!quit);
		this.model.getScanner().close();
		this.vue.displayAppEnd();
	}

	/**
	 * Méthode qui affiche le top10 des villes les plus peuplées de France. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * appelle la methode qui affiche la liste du top 10 des villes les plus peuplées de France, 
	 * et attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayTopTenPopVilleFrance(ArrayList<Ville> listVilles, Scanner scanner) {
		this.vue.displayMenu08();
		this.displayTopTenPopVilleFrance(listVilles);
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche le top10 des villes les plus peuplées d'une région choisie. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * attend la choix d'un code de région par l'utilisateur, 
	 * appelle la méthode qui génère la liste des communes de la région choisie par l'utilisateur, 
	 * trie la liste selon la population en ordre décroissant, 
	 * puis appelle la méthode de la vue qui affiche les 10 1ers éléments de la liste, 
	 * et attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param listRegions : liste des régions collectées
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayTopTenPopVilleByRegion(ArrayList<Ville> listVilles, ArrayList<Region> listRegions, Scanner scanner) {
		this.vue.displayMenu07();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Region regionToTest = this.makeRegionFromCode(choiceString, listRegions);		
		if (regionToTest == null) {
			this.vue.displayRegionNotFound(choiceString);
		}
		else {
			ArrayList<Ville> listVilleRegion = this.generateVilleByRegionList(regionToTest, listVilles, listRegions);
			ComparatorVilleByPopDecr comparator = new ComparatorVilleByPopDecr();
			Collections.sort(listVilleRegion, comparator);
			this.vue.displayRegionInfos(regionToTest);
			this.vue.displayTopTenVilleList(listVilleRegion);
		}
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche le top10 des villes les plus peuplées d'un département choisi. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * attend la choix d'un code de département par l'utilisateur, 
	 * appelle la méthode qui génère la liste des communes du département choisi par l'utilisateur, 
	 * trie la liste selon la population en ordre décroissant, 
	 * puis appelle la méthode de la vue qui affiche les 10 1ers éléments de la liste, 
	 * et attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param listDpts : liste des départements collectés
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayTopTenPopVilleByDept(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts, Scanner scanner) {
		this.vue.displayMenu06();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Departement deptToTest = new Departement(choiceString, "", "", 0L);
		deptToTest = findAndReturnDept(deptToTest, this.model.getListDpts());
		ArrayList<Ville> listVilleDept = this.generateVilleByDeptList(deptToTest, listVilles, listDpts);
		if (listVilleDept == null) {
			this.vue.displayDeptNotFound(choiceString);
		}
		else {
			ComparatorVilleByPopDecr comparator = new ComparatorVilleByPopDecr();
			Collections.sort(listVilleDept, comparator);
			this.vue.displayDeptInfos(deptToTest);
			this.vue.displayTopTenVilleList(listVilleDept);
		}	
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche le top10 des départements les plus peuplés de France. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * appelle la méthode qui affecte les populations de la liste des département et l'affiche, 
	 * puis attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param listDpts : liste des départements collectés
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayTopTenDeptPop(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts, Scanner scanner) {
		this.vue.displayMenu05();
		this.generateAndDisplayTopTenDeptList(listVilles, listDpts);
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche le top10 des régions les plus peuplées de France. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * appelle la méthode qui affecte les populations de la liste des régions et l'affiche, 
	 * puis attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param listRegion : liste des départements collectés
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayTopTenRegionPop(ArrayList<Ville> listVilles, ArrayList<Region> listRegion, Scanner scanner) {
		this.vue.displayMenu04();
		this.generateAndDisplayTopTenRegionList(listVilles, listRegion);
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche la population d'une région choisie. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * attend la saisie du code de la région à traiter, 
	 * appelle la méthode qui calcule la population de la région choisie, 
	 * si le code n'est pas reconnu : appelle la méthode de la vue correspondante, 
	 * si le code est ok : appelle la méthode de la vue qui affiche les infos de la région, 
	 * puis attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayRegionPop(ArrayList<Ville> listVilles, Scanner scanner) {
		this.vue.displayMenu03();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Region regionToTest = this.calcPopRegion(choiceString, listVilles);
		Long popRegion = regionToTest.getPopulTotale();
		if(popRegion > 0) {
			this.vue.displayRegion(regionToTest);
		}
		else {
			this.vue.displayRegionNotFound(choiceString);
		}
		
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche la population d'un département choisi. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * attend la saisie du code du département à traiter, 
	 * appelle la méthode qui calcule la population du département choisi, 
	 * si le code n'est pas reconnu : appelle la méthode de la vue correspondante, 
	 * si le code est ok : appelle la méthode de la vue qui affiche les infos du département, 
	 * puis attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayDeptPop(ArrayList<Ville> listVilles, ArrayList<Departement> listDepts, Scanner scanner) {
		this.vue.displayMenu02();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Departement dept = this.calcPopDept(choiceString, listVilles);
		Long popDept = dept.getPopulTotale();
		dept = findAndReturnDept(dept, listDepts);
		dept.setPopulTotale(popDept);
		if(popDept > 0) {
			this.vue.displayDept(dept);
		}
		else {
			this.vue.displayDeptNotFound(choiceString);
		}
		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui affiche la population d'une ville choisie. 
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * attend la saisie du nom de la ville a traiter, 
	 * passe la String saisie en majuscule, 
	 * crée un objet Ville retourné par la méthode qui cherche et renvoie la ville correspondante à la saisie, 
	 * si objet ville différent de null : appel de la méthode la vue qui affiche les infos de la ville, 
	 * sinon : appel de la méthode la vue qui affiche qu'il n'y a pas de ville à ce nom, 
	 * puis attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param listVilles : liste des villes à traiter
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void searchAndDisplayVille(ArrayList<Ville> listVilles, Scanner scanner) {
		this.vue.displayMenu01();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Ville foundVille = this.searchVille(choiceString, listVilles);
		if (foundVille != null) {
			this.vue.displayVille(foundVille);
		}
		else {
			this.vue.displayVilleNotFound(choiceString);
		}

		this.waitForCToContinue(scanner);
	}

	/**
	 * Méthode qui renvoie la ville trouvée dans la liste à partir du nom passé en paramètre, 
	 * boucle sur la liste des villes, 
	 * si une ville correspond : renvoie un clone de la ville trouvée, 
	 * sinon : renvoie null. 
	 * 
	 * @param nomVille : nom de la ville a trouver
	 * @param listVilles : liste des villes à traiter
	 * @return objet ville trouvé ou null si rien trouvé
	 */
	private Ville searchVille(String nomVille, ArrayList<Ville> listVilles) {
		for (Ville ville : listVilles) {
			if (ville.getNomCom().toUpperCase().equals(nomVille)) {
				return ville.clone();
			}	
		}
		return null;
	}
	
	/**
	 * Méthode qui affiche le top 10 des villes les plus peuplées de France, 
	 * crée un objet comparator qui trie des villes selon la population en ordre décroissant, 
	 * execute le tri sur la liste des villes, 
	 * appelle la fonction de la vue qui affiche les dix premiers éléments de la liste.  
	 * 
	 * @param listVilles : liste des villes à traiter
	 */
	private void displayTopTenPopVilleFrance(ArrayList<Ville> listVilles) {
		ComparatorVilleByPopDecr comparator = new ComparatorVilleByPopDecr();
		Collections.sort(listVilles, comparator);
		this.vue.displayTopTenVilleList(listVilles);
	}
	
	/**
	 * Méthode qui renvoie un objet région de la liste des régions à partir du code passé en paramètre, 
	 * boucle sur la liste des régions, 
	 * si le code est trouvé dans la liste : retourne un clone de la région trouvée dans la liste, 
	 * sinon : renvoie null. 
	 * 
	 * @param codeRegion : code de la région à utiliser
	 * @param listRegions : liste des régions
	 * @return objet région trouvé ou null si rien trouvé
	 */
	private Region makeRegionFromCode(String codeRegion, ArrayList<Region> listRegions) {
		for(Region region : listRegions) {
			if(region.getCodeRegion().equals(codeRegion)) {
				return region.clone();
			}
		}
		return null;
	}
	
	private Departement findAndReturnDept(Departement deptToTest, ArrayList<Departement> listDepts) {
		for (Departement dept : listDepts) {
			if (dept.equals(deptToTest)) {
				Departement deptToReturn = dept.clone();
				return deptToReturn;
			}
		}
		return null;
	}
	
	/**
	 * Méthode qui renvoie la liste des villes de la région passée en paramètre, 
	 * si le code existe dans la liste des regions : construit la liste avec une boucle sur la liste des villes et retourne la liste, 
	 * sinon : retourne null. 
	 * 
	 * @param regionToTest : région à utiliser pour filtrer la liste des villes
	 * @param listVilles : liste des villes à traiter
	 * @param listRegions : liste des régions
	 * @return liste des villes de la région ou null si la région n'existe pas dans la liste
	 */
	private ArrayList<Ville> generateVilleByRegionList(Region regionToTest, ArrayList<Ville> listVilles, ArrayList<Region> listRegions) {
		boolean isCodeOk = listRegions.contains(regionToTest);
		if (isCodeOk) {
			ArrayList<Ville> listToReturn = new ArrayList<>();
			for(Ville ville : listVilles) {
				if(ville.getCodeRegion().equals(regionToTest.getCodeRegion())) {
					listToReturn.add(ville);
				}
			}
			return listToReturn;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Méthode qui renvoie la liste des villes du département passé en paramètre, 
	 * si le code existe dans la liste des départements : construit la liste avec une boucle sur la liste des villes et retourne la liste, 
	 * sinon : retourne null. 
	 * 
	 * @param deptToTest : département à utiliser pour filtrer la liste des villes
	 * @param listVilles : liste des villes à traiter
	 * @param listDpts : liste des départements
	 * @return liste des villes de la région ou null si la région n'existe pas dans la liste
	 */
	private ArrayList<Ville> generateVilleByDeptList(Departement deptToTest, ArrayList<Ville> listVilles, ArrayList<Departement> listDpts) {
		boolean isCodeOk = listDpts.contains(deptToTest);
		if (isCodeOk) {
			ArrayList<Ville> listToReturn = new ArrayList<>();
			for(Ville ville : listVilles) {
				if(ville.getCodeDept().equals(deptToTest.getCodeDept())) {
					listToReturn.add(ville);
				}
			}
			return listToReturn;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Méthode qui calcule les populations des départements de la liste en fonctions des villes de la liste, 
	 * trie la liste des départements selon la population en ordre décroissant, 
	 * appelle la méthode de la vue qui affiche les dix premiers éléments de la liste des départements. 
	 * 
	 * @param listVilles : liste des villes
	 * @param listDpts : liste des départements
	 */
	private void generateAndDisplayTopTenDeptList(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts) {
		for (Ville ville : listVilles) {
			Departement deptToTest = new Departement(ville.getCodeDept(), "", "", 0L);
			for (Departement dept : listDpts) {
				if (dept.equals(deptToTest)) {
					dept.setPopulTotale(dept.getPopulTotale() + ville.getPopulTotale());
				}
			}	
		}
		
		ComparatorDptByPopDecr comparator = new ComparatorDptByPopDecr();
		Collections.sort(listDpts, comparator);
		this.vue.displayTopTenDeptList(listDpts);
		
	}
	
	/**
	 * Méthode qui calcule les populations des régions de la liste en fonction des villes de la liste, 
	 * trie la liste des régions selon la population en ordre décroissant, 
	 * appelle la méthode de la vue qui affiche les dix premiers éléments de la liste des régions. 
	 * 
	 * @param listVilles : liste des villes
	 * @param listRegion : liste des régions
	 */
	private void generateAndDisplayTopTenRegionList(ArrayList<Ville> listVilles, ArrayList<Region> listRegion) {
		for (Ville ville : listVilles) {
			Region regionToTest = new Region(ville.getCodeRegion(), ville.getNomRegion(), 0L);
			for (Region region : listRegion) {
				if (region.equals(regionToTest)) {
					region.setPopulTotale(region.getPopulTotale() + ville.getPopulTotale());
				}
			}	
		}
		ComparatorRegionByPopDecr comparator = new ComparatorRegionByPopDecr();
		Collections.sort(listRegion, comparator);
		this.vue.displayTopTenRegionList(listRegion);
	}
	
	/**
	 * Méthode qui renvoie une objet région selon code passé en paramètre, 
	 * dont la population est calculée en fonction des populations des villes de la liste. 
	 * 
	 * @param codeRegion : code de la région utilisée
	 * @param listVilles : liste des villes
	 * @return objet région dont la population a été mise à jour
	 */
	private Region calcPopRegion(String codeRegion, ArrayList<Ville> listVilles) {
		Long popTotale = 0L;
		Region regionToReturn = new Region(codeRegion, "", 0L);
		for (Ville ville : listVilles) {
			if (ville.getCodeRegion().toUpperCase().equals(codeRegion)) {
				popTotale += ville.getPopulTotale();
				regionToReturn.setNomRegion(ville.getNomRegion());
			}
		}
		regionToReturn.setPopulTotale(popTotale);
		return regionToReturn;
	}
	
	/**
	 * Méthode qui renvoie une objet département selon code passé en paramètre, 
	 * dont la population est calculée en fonction des populations des villes de la liste. 
	 * 
	 * @param codeDept : code du département utilisé
	 * @param listVilles : liste des villes
	 * @return objet département dont la population a été mise à jour
	 */
	private Departement calcPopDept(String codeDept, ArrayList<Ville> listVilles) {
		Long popTotale = 0L;
		String codeRegion = "";
		Departement deptToReturn = new Departement(codeDept, "", "", 0L);
		for (Ville ville : listVilles) {
			if (ville.getCodeDept().toUpperCase().equals(codeDept)) {
				popTotale += ville.getPopulTotale();
				codeRegion = ville.getCodeRegion();
			}
		}
		deptToReturn.setPopulTotale(popTotale);
		deptToReturn.setCodeReg(codeRegion);
		return deptToReturn;
	}
	
	/**
	 * Méthode chargée de peupler la liste des villes, des départements et des régions, 
	 * Affiche le menu correspondant, met a jour le booléen isFileLoaded en appellant la méthode 
	 * du modéle qui peuples les liste à partir du fichier .csv (fichier modifié pour que Lyon soit gérée), 
	 * appelle la méthode de la vue qui affiche le nombre de villes crées, 
	 * et attend la saisie de 'c' pour revenir au menu principal. 
	 * 
	 * @param scanner : pour gérer les saisies du clavier
	 */
	private void loadDatasFromCSV(Scanner scanner) {
		this.vue.displayMenu00();
		try {
			this.model.setIsFileLoaded(this.model.loadDatasFromFile());
		} 
		catch (IOException e) {
			this.model.setIsFileLoaded(false);
			this.vue.displayIOErrorMessage(e);
		}
		if(this.model.getIsFileLoaded()) {
			this.vue.displayInfosDatas(this.model.getListVilles(), this.model.getListDpts(), this.model.getListRegions());
		}
		else {
			this.vue.displayCSVNotLoaded();
		}
		this.waitForCToContinue(scanner);
	}

   /**
	* Méthode qui attend la saisie de 'C' par l'utilisateur pour continuer. 
	* Appelle la méthode la vue qui affiche le texte appelant à saisie 'c' pour continuer, 
 	* attend que la saisie soit correcte pour continuer. 
 	* 
 	* @param scanner : pour gérer les saisies du clavier
 	*/
	private void waitForCToContinue(Scanner scanner) {
		char choice;
		do {
			this.vue.displayContinue();
			String choiceString2 = scanner.next();
			choice = choiceString2.charAt(0);
		}
		while (choice != 'C' && choice != 'c');
	}

}
