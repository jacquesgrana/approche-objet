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
	 * initialisation
	 */
	public void init() {
		//System.out.println("init Controller");
		this.model = new Model();
		this.vue = new Vue();
		this.model.init(); // TODO enlever, tout est fait dans le constructeur de Model
	}
	
	// TODO gestion des exceptions !!!

	/**
	 * méthode principale de l'application, 
	 * affiche le menu et appelle les méthodes selon les choix de l'utilisateur
	 * @throws IOException
	 */
	public void run() throws IOException {
		//System.out.println("run Controller");
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
					loadDatasFromCSV(this.model.getScanner());
				}
				break;
			case '1' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayVille(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			case '2' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayDeptPop(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			case '3' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayRegionPop(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			case '4' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayTopTenRegionPop(this.model.getListVilles(), this.model.getListRegions(), this.model.getScanner());
				}
				break;
			case '5' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayTopTenDeptPop(this.model.getListVilles(), this.model.getListDpts(), this.model.getScanner());
				}
				break;
			case '6' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayTopTenPopVilleByDept(this.model.getListVilles(), this.model.getListDpts(), this.model.getScanner());
				}
				break;
			case '7' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayTopTenPopVilleByRegion(this.model.getListVilles(), this.model.getListRegions(), this.model.getScanner());
				}
				break;
			case '8' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayTopTenPopVilleFrance(this.model.getListVilles(), this.model.getScanner());
				}
				break;
			}
		}
		while (!quit);
		this.model.getScanner().close();
		System.out.println("\n\nFin du programme");
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant,
	 * appelle la methode qui affiche la liste du top 10 des villes les plus peuplées de France
	 * et attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayTopTenPopVilleFrance(ArrayList<Ville> listVilles, Scanner scanner) {
		this.vue.displayMenu08();
		displayTopTenPopVilleFrance(listVilles);
		waitForCToContinue(scanner);
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant, 
	 * attend la choix d'un code de région par l'utilisateur, 
	 * appelle la méthode qui génère la liste des communes de la région choisie par l'utilisateur,
	 * trie la liste selon la population en ordre décroissant, 
	 * puis appelle la méthode de la vue qui affiche les 10 1ers éléments de la liste 
	 * et attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param listRegions liste des régions collectées
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayTopTenPopVilleByRegion(ArrayList<Ville> listVilles, ArrayList<Region> listRegions, Scanner scanner) {
		this.vue.displayMenu07();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		// TODO appel fonction qui renvoie un objet Region a partir de choiceString et de listRegions si code pas ok renvoie null
		Region regionToTest = makeRegionFromCode(choiceString, listRegions);
		//System.out.println("région choisie : " + regionToTest.toString());
		
		if (regionToTest == null) {
			this.vue.displayRegionNotFound(choiceString);
		}
		else {
			ArrayList<Ville> listVilleRegion = generateVilleByRegionList(regionToTest, listVilles, listRegions);
			if (listVilleRegion == null) {
				// appel methode vue
				this.vue.displayRegionNotFound(choiceString);
			}
			else {
				ComparatorVilleByPopDecr comparator = new ComparatorVilleByPopDecr();
				Collections.sort(listVilleRegion, comparator);
				this.vue.displayRegionInfos(regionToTest);
				this.vue.displayTopTenPopVille(listVilleRegion);
			}
		}
		waitForCToContinue(scanner);
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant,
	 * attend la choix d'un code de département par l'utilisateur, 
	 * appelle la méthode qui génère la liste des communes du département choisi par l'utilisateur,
	 * trie la liste selon la population en ordre décroissant, 
	 * puis appelle la méthode de la vue qui affiche les 10 1ers éléments de la liste 
	 * et attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param listDpts liste des départements collectés
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayTopTenPopVilleByDept(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts, Scanner scanner) {
		//char choice = 'X';
		this.vue.displayMenu06();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Departement deptToTest = new Departement(choiceString, 0L);
		// appel methode qui renvoie une ArrayList des villes du département ou null
		ArrayList<Ville> listVilleDept = generateVilleByDeptList(deptToTest, listVilles, listDpts);
		//	si arraylist null
		if (listVilleDept == null) {
			// appel methode vue
			this.vue.displayDeptNotFound(choiceString);
		}
		else {
			// tri arraylist selon la pop decroissant
			ComparatorVilleByPopDecr comparator = new ComparatorVilleByPopDecr();
			Collections.sort(listVilleDept, comparator);
			
			// appel methode vue qui affiche les 10 1e elements de l'arraylist
			this.vue.displayDeptInfos(deptToTest);
			this.vue.displayTopTenPopVille(listVilleDept);
		}	
		waitForCToContinue(scanner);
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant,
	 * appelle la méthode qui affecte les populations de la liste des département et l'affiche,
	 * puis attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param listDpts liste des départements collectés
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayTopTenDeptPop(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts, Scanner scanner) {
		//char choice = 'X';
		this.vue.displayMenu05();
		generateTopTenDeptList(listVilles, listDpts);
		waitForCToContinue(scanner);
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant,
	 * appelle la méthode qui affecte les populations de la liste des régions et l'affiche,
	 * puis attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param listRegion liste des départements collectés
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayTopTenRegionPop(ArrayList<Ville> listVilles, ArrayList<Region> listRegion, Scanner scanner) {
		//char choice = 'X';
		this.vue.displayMenu04();
		generateTopTenRegionList(listVilles, listRegion);
		waitForCToContinue(scanner);
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant,
	 * attend la saisie du code de la région à traiter,
	 * appelle la méthode qui calcule la population de la région choisie,
	 * si le code n'est pas reconnu : appelle la méthode de la vue correspondante,
	 * si le code est ok : appelle la méthode de la vue qui affiche les infos de la région,
	 * puis attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayRegionPop(ArrayList<Ville> listVilles, Scanner scanner) {
		//char choice = 'X';
		this.vue.displayMenu03();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Region regionToTest = calcPopRegion(choiceString, listVilles);
		Long popRegion = regionToTest.getPopulTotale();
		if(popRegion > 0) {
			this.vue.displayPopRegion(regionToTest);
		}
		else {
			this.vue.displayRegionNotFound(choiceString);
		}
		
		waitForCToContinue(scanner);
	}

	/**
	 * Appelle la fonction de la vue qui affiche le menu correspondant,
	 * attend la saisie du code du département à traiter,
	 * appelle la méthode qui calcule la population du département choisi,
	 * si le code n'est pas reconnu : appelle la méthode de la vue correspondante,
	 * si le code est ok : appelle la méthode de la vue qui affiche les infos du département,
	 * puis attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param listVilles liste des villes à traiter
	 * @param scanner pour la gestion du clavier
	 */
	private void searchAndDisplayDeptPop(ArrayList<Ville> listVilles, Scanner scanner) {
		//char choice = 'X';
		this.vue.displayMenu02();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		
		// renvoyer un dept
		Departement dept = calcPopDept(choiceString, listVilles);
		Long popDept = dept.getPopulTotale();
		if(popDept > 0) {
			this.vue.displayPopDept(dept);
		}
		else {
			this.vue.displayDeptNotFound(choiceString);
		}
		waitForCToContinue(scanner);
	}

	// TODO probleme pour lyon --> modifier csv? -- FAIT - fichier csv modifié
	private void searchAndDisplayVille(ArrayList<Ville> listVilles, Scanner scanner) {
		//char choice = 'X';
		this.vue.displayMenu01();
		// saisir nom ville
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Ville foundVille = searchVille(choiceString, listVilles);
		// si nom trouvé --> affiche le nom et la population de la ville
		if (foundVille != null) {
			// appel methode vue qui affiche les infos de la ville
			this.vue.displayVille(foundVille);

		}
		// sinon --> affiche ville inconnue 
		else {
			this.vue.displayVilleNotFound(choiceString);
			// appel methode vue qui affiche pas de ville a ce nom
			//System.out.println("objet null");

		}

		waitForCToContinue(scanner);
	}

	private Ville searchVille(String nomVille, ArrayList<Ville> listVilles) {
		// parcours liste
		for (Ville ville : listVilles) {
			// si nomVille = ville.getNom
			if (ville.getNomCom().toUpperCase().equals(nomVille)) {
				// return ville
				return ville;
			}	
		}

		return null;
	}
	
	private void displayTopTenPopVilleFrance(ArrayList<Ville> listVilles) {
		ComparatorVilleByPopDecr comparator = new ComparatorVilleByPopDecr();
		Collections.sort(listVilles, comparator);
		this.vue.displayTopTenPopVille(listVilles);
	}
	
	private Region makeRegionFromCode(String codeRegion, ArrayList<Region> listRegions) {
		for(Region region : listRegions) {
			if(region.getCodeRegion().equals(codeRegion)) {
				Region regionToReturn = region.clone();
				return regionToReturn;
			}
		}
		return null;
	}
	
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
	
	private void generateTopTenDeptList(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts) {
		for (Ville ville : listVilles) {
			Departement deptToTest = new Departement(ville.getCodeDept(),0L);
			for (Departement dept : listDpts) {
				if (dept.equals(deptToTest)) {
					dept.setPopulTotale(dept.getPopulTotale() + ville.getPopulTotale());
				}
				
			}
				
		}
		
		ComparatorDptByPopDecr comparator = new ComparatorDptByPopDecr();
		Collections.sort(listDpts, comparator);
		this.vue.displayTopTenDeptByPop(listDpts);
		
	}
	
	private void generateTopTenRegionList(ArrayList<Ville> listVilles, ArrayList<Region> listRegion) {
		// boucle sur ville
		for (Ville ville : listVilles) {
			// construction objet region
			Region regionToTest = new Region(ville.getCodeRegion(), ville.getNomRegion(), 0L);
			// boucle sur region
			for (Region region : listRegion) {
				// si region ==
				if (region.equals(regionToTest)) {
					// augmente popul region
					region.setPopulTotale(region.getPopulTotale() + ville.getPopulTotale());
				}
				
			}
				
		}
		
		// tri region selon population : appel comparatorPop
		ComparatorRegionByPopDecr comparator = new ComparatorRegionByPopDecr();
		Collections.sort(listRegion, comparator);
		// appel fonction vue qui affiche les 10 1e elements de la liste (code : + nom : + pop :)
		this.vue.displayTopTenRegionByPop(listRegion);
		//this.vue.displayContinue();
		
	}
	
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
	
	private Departement calcPopDept(String codeDept, ArrayList<Ville> listVilles) {
		Long popTotale = 0L;
		Departement deptToReturn = new Departement(codeDept, 0L);
		for (Ville ville : listVilles) {
			if (ville.getCodeDept().toUpperCase().equals(codeDept)) {
				popTotale += ville.getPopulTotale();
			}
		}
		deptToReturn.setPopulTotale(popTotale);
		return deptToReturn;
	}

	// TODO gérer exception ici
	
	/**
	 * Méthode chargée de peupler la liste des villes, des départements et des régions
	 * Affiche le menu correspondant, met a jour le booléen isFileLoaded en appellant la méthode
	 * du modéle qui peuples les liste à partir du fichier .csv (fichier modifié pour que Lyon soit gérée), 
	 * appelle la méthode de la vue qui affiche le nombre de villes crées,
	 * et attend la saisie de 'c' pour revenir au menu principal
	 * 
	 * @param scanner
	 * @throws IOException
	 */
	private void loadDatasFromCSV(Scanner scanner) throws IOException {
		this.vue.displayLoadDataMenu();
		this.model.setIsFileLoaded(this.model.loadDatasFromFile());
		this.vue.displayInfosDatas(this.model.getListVilles());
		//char choice = 'X';
		waitForCToContinue(scanner);

	}

   /**
	* Méthode qui attend la saisie de 'C' par l'utilisateur pour continuer
	* Appelle la méthode la vue qui affiche le texte appelant à saisie 'c' pour continuer,
 	* attend que la saisie soit correcte pour continuer
 	* 
 	* @param scanner pour la gestion du clavier
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

/*
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Vue getVue() {
		return vue;
	}

	public void setVue(Vue vue) {
		this.vue = vue;
	}*/

}
