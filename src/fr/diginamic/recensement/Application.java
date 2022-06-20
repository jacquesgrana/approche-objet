package fr.diginamic.recensement;

import fr.diginamic.recensement.controller.ControllerApp;

public class Application {

	/**
	 * Point d'entrée de l'application
	 * instancie, initialise et lance le contrôleur de l'application
	 * 
	 * @see ControllerApp
	 * @param args : paramètres du main
	 * @version 1.0
	 * @author jacques granarolo
	 */
	public static void main(String[] args){
		ControllerApp controller = new ControllerApp();
		controller.init();
		controller.run();
	}
}
