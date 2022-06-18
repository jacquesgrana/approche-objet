package fr.diginamic.recensement.model;

import java.util.Scanner;

public class Model {
	
	private Scanner scanner;
	private boolean isFileLoaded;
	
	public Model() {
		this.scanner = new Scanner(System.in);
		this.isFileLoaded = false;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public boolean getIsFileLoaded() {
		return isFileLoaded;
	}

	public void setIsFileLoaded(boolean isFileLoaded) {
		this.isFileLoaded = isFileLoaded;
	}

}
