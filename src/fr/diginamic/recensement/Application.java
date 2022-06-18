package fr.diginamic.recensement;

import java.io.IOException;

import fr.diginamic.recensement.controller.ControllerApp;

public class Application {

	/**
	 * Point d'entrée de l'application
	 * initialise et lance le controlleur
	 * 
	 * @see ControllerApp
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ControllerApp controller = new ControllerApp();
		
		controller.init();
		controller.run();

	}

}
