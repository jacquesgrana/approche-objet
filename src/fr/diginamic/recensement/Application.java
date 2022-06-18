package fr.diginamic.recensement;

import fr.diginamic.recensement.controller.ControllerApp;

public class Application {

	/**
	 * Point d'entrée de l'application
	 * initialise et lance le controlleur
	 * 
	 * @see ControllerApp
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControllerApp controller = new ControllerApp();
		
		controller.init();
		controller.run();

	}

}
