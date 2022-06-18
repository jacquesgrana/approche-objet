package fr.diginamic.recensement.controller;

import java.io.IOException;
import java.util.ArrayList;

import fr.diginamic.recensement.model.Model;
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
					loadDatasFromCSV();
				}
				break;
			case '1' :
				if (model.getIsFileLoaded()) {
					searchAndDisplayVille(this.model.getListVilles());
				}
				break;
			}
		}
		while (!quit);
		this.model.getScanner().close();
		System.out.println("\n\nFin du programme");
	}

	private void searchAndDisplayVille(ArrayList<Ville> listVilles) {
		char choice = 'X';
		this.vue.displayMenu01();
		// saisir nom ville
		String choiceString = this.model.getScanner().next();
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
			
		// attend 'c' pour retour au menu
		do { // TODO factoriser
			this.vue.displayContinue();
			String choiceString2 = this.model.getScanner().next();
			choice = choiceString2.charAt(0);
		}
		while (choice != 'C' && choice != 'c');
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

	private void loadDatasFromCSV() throws IOException {
		this.vue.displayLoadDataMenu();
		this.model.setIsFileLoaded(this.model.loadDatasFromFile());
		this.vue.displayInfosDatas(this.model.getListVilles());
		char choice = 'X';
		do { // TODO factoriser
			this.vue.displayContinue();
			String choiceString = this.model.getScanner().next();
			choice = choiceString.charAt(0);
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
