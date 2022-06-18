package fr.diginamic.recensement.controller;

import fr.diginamic.recensement.model.Model;
import fr.diginamic.recensement.vue.Vue;

public class ControllerApp {
	
	private Model model;
	private Vue vue;
	
	public ControllerApp() {
		
	}
	
	public void init() {
		//System.out.println("init Controller");
		this.model = new Model();
		this.vue = new Vue();
		//this.model.getScanner() = new Scanner(System.in);
		//Scanner scan = new Scanner(System.in);
	}
	
	public void run() {
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
			}
		}
		while (!quit);
		System.out.println("\n\nFin du programme");
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
