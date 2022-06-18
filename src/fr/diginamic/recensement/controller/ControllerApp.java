package fr.diginamic.recensement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import fr.diginamic.recensement.model.ComparatorDptByPopDecr;
import fr.diginamic.recensement.model.ComparatorRegionByPopDecr;
import fr.diginamic.recensement.model.Departement;
import fr.diginamic.recensement.model.Model;
import fr.diginamic.recensement.model.Region;
import fr.diginamic.recensement.model.Ville;
import fr.diginamic.recensement.vue.Vue;

/**
 * Classe controlleur de l'application, utilise model et vue
 * 
 * @see Model
 * @see Vue
 * @see Ville
 * @author jacques granarolo
 */
public class ControllerApp {

	private Model model;
	private Vue vue;

	public ControllerApp() {

	}

	public void init() {
		//System.out.println("init Controller");
		this.model = new Model();
		this.vue = new Vue();
		this.model.init();
	}

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
			}
		}
		while (!quit);
		this.model.getScanner().close();
		System.out.println("\n\nFin du programme");
	}

	private void searchAndDisplayTopTenDeptPop(ArrayList<Ville> listVilles, ArrayList<Departement> listDpts, Scanner scanner) {
		char choice = 'X';
		this.vue.displayMenu05();
		generateTopTenDeptList(listVilles, listDpts);
		waitForCToContinue(scanner);
	}

	private void searchAndDisplayTopTenRegionPop(ArrayList<Ville> listVilles, ArrayList<Region> listRegion, Scanner scanner) {
		char choice = 'X';
		this.vue.displayMenu04();
		generateTopTenRegionList(listVilles, listRegion);
		waitForCToContinue(scanner);
	}

	private void searchAndDisplayRegionPop(ArrayList<Ville> listVilles, Scanner scanner) {
		char choice = 'X';
		this.vue.displayMenu03();
		String choiceString = scanner.next();
		choiceString = choiceString.toUpperCase();
		Region region = calcPopRegion(choiceString, listVilles);
		Long popRegion = region.getPopulTotale();
		if(popRegion > 0) {
			this.vue.displayPopRegion(region);
		}
		else {
			this.vue.displayRegionNotFound(choiceString);
		}
		
		waitForCToContinue(scanner);
	}

	private void searchAndDisplayDeptPop(ArrayList<Ville> listVilles, Scanner scanner) {
		char choice = 'X';
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
		char choice = 'X';
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

	private void loadDatasFromCSV(Scanner scanner) throws IOException {
		this.vue.displayLoadDataMenu();
		this.model.setIsFileLoaded(this.model.loadDatasFromFile());
		this.vue.displayInfosDatas(this.model.getListVilles());
		char choice = 'X';
		waitForCToContinue(scanner);

	}


	private void waitForCToContinue(Scanner scanner) {
		char choice;
		do {
			this.vue.displayContinue();
			String choiceString2 = scanner.next();
			choice = choiceString2.charAt(0);
		}
		while (choice != 'C' && choice != 'c');
	}


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
	}

}
