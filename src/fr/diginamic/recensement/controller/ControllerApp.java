package fr.diginamic.recensement.controller;

import java.io.IOException;

import fr.diginamic.recensement.model.Model;
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
			}
		}
		while (!quit);
		this.model.getScanner().close();
		System.out.println("\n\nFin du programme");
	}

	private void loadDatasFromCSV() throws IOException {
		this.vue.displayLoadDataMenu();
		this.model.setIsFileLoaded(this.model.loadDatasFromFile());
		this.vue.displayInfosDatas(this.model.getListVilles());
		char choice = 'X';
		do {
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
