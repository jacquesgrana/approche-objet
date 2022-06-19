package fr.diginamic.recensement.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Classe contenant les données de l'application : 
 * scanner : pour la gestion des saisies du clavier, 
 * isFileLoaded : booléen indiquant si les listes ont été initialisées, 
 * listVilles : liste des villes, 
 * listDpts : liste des départements, 
 * listRegions : liste des régions. 
 * 
 * @author jacques granarolo
 */
public class Model {
	
	private Scanner scanner;
	private boolean isFileLoaded;
	private ArrayList<Ville> listVilles;
	private ArrayList<Departement> listDpts;
	private ArrayList<Region> listRegions;
	
	public Model() {
		this.scanner = new Scanner(System.in);
		this.isFileLoaded = false;
		this.listVilles = new ArrayList<>();
		this.listDpts = new ArrayList<>();
		this.listRegions = new ArrayList<>();
	}
	
	public void init() {
		
	}
	
	/**
	 * Méthode qui collecte les départements depuis la liste des villes et construit la liste des départements. 
	 * 
	 */
	private void initListDpts() {
		Departement firstDpt = new Departement(this.listVilles.get(0).getCodeDept(), 0L);
		Departement deptToTest = null;
		this.listDpts.add(firstDpt);
		for (Ville ville : this.listVilles) {
			deptToTest = new Departement(ville.getCodeDept(), 0L);		
			if(!this.listDpts.contains(deptToTest)) {
				this.listDpts.add(deptToTest);
			}			
		}		
	}
	
	// TODO paramètres ?
	/**
	 * Méthode qui collecte les régions depuis la liste des villes et construit la liste des régions. 
	 * 
	 */
	private void initListRegions() {
		Region firstRegion = new Region(this.listVilles.get(0).getCodeRegion(), this.listVilles.get(0).getNomRegion(), 0L);
		Region regionToTest = null;
		this.listRegions.add(firstRegion);
		for (Ville ville : this.listVilles) {
			regionToTest = new Region(ville.getCodeRegion(), ville.getNomRegion(), 0L);
			if(!this.listRegions.contains(regionToTest)) {
				this.listRegions.add(regionToTest);
			}			
		}
	}

	/**
	 * Méthode qui vérifie l'existence du ficher, renvoie faux si fichier pas ok, sinon charge les données dans la liste des villes, 
	 * initialise les liste des régions et des départements, 
	 * puis renvoie vrai.
	 * 
	 * @return vrai si fichier ok et chargé, sinon faux
	 * @throws IOException
	 */
	public boolean loadDatasFromFile() throws IOException {
		System.out.println("\n  Chargement des données à partir du fichier");
		
		Path path = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fr/diginamic/recensement/files/recensement-modif-Lyon.csv");
		boolean isFile = Files.isRegularFile(path);
		boolean isReadable = Files.isReadable(path);
		boolean isFileExists = Files.exists(path);
		
		if(!isFileExists || !isFile || !isReadable) {
			// TODO affichage erreur ?
			return false;
		}
		else {
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.remove(0);
			for (String line: lines) {
				String[] tabOneLine = line.split(";");
				Ville ville = new Ville(tabOneLine[0], tabOneLine[1], tabOneLine[2], tabOneLine[5], tabOneLine[6], Long.parseLong(tabOneLine[7].trim().replaceAll(" ", "")));
				this.listVilles.add(ville);
			}
			initListDpts();
			initListRegions();
			return true;
		}
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

	public ArrayList<Departement> getListDpts() {
		return listDpts;
	}

	public void setListDpts(ArrayList<Departement> listDpts) {
		this.listDpts = listDpts;
	}

	public ArrayList<Region> getListRegions() {
		return listRegions;
	}

	public void setListRegions(ArrayList<Region> listRegions) {
		this.listRegions = listRegions;
	}
}
