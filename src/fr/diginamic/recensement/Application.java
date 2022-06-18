package fr.diginamic.recensement;

import fr.diginamic.recensement.controller.ControllerApp;

public class Application {

	public static void main(String[] args) {
		
		ControllerApp controller = new ControllerApp();
		
		controller.init();
		controller.run();

	}

}
