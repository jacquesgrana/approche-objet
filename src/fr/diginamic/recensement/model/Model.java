package fr.diginamic.recensement.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe contenant les données de l'application
 * 
 * @author jacques granarolo
 */
public class Model {
	
	private Scanner scanner;
	private boolean isFileLoaded;
	private ArrayList<Ville> listVilles;
	
	public Model() {
		this.scanner = new Scanner(System.in);
		this.isFileLoaded = false;
		this.listVilles = new ArrayList<>();
	}
	
	public void loadDatasFromFile() {
		System.out.println("\n  Chargement des données à partir du fichier ok");
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

	public ArrayList<Ville> getListVilles() {
		return listVilles;
	}

	public void setListVilles(ArrayList<Ville> listVilles) {
		this.listVilles = listVilles;
	}

}
