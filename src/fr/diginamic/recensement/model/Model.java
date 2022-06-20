package fr.diginamic.recensement.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
 * La liste des villes est générée à partir du fichier .csv du recensement, 
 * la liste des départements est générée initialement à partir de la liste des villes, 
 * puis complétée (pour ajouter le nom et le codeRegion) à partir du fichier .csv de l'insee pour les départements 
 * et la liste des régions est générée à partir de la liste des villes. 
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
		
	}
	
	public void init() {
		this.scanner = new Scanner(System.in);
		this.isFileLoaded = false;
		this.listVilles = new ArrayList<>();
		this.listDpts = new ArrayList<>();
		this.listRegions = new ArrayList<>();
	}
	
	/**
	 * Méthode qui collecte les départements depuis la liste des villes et construit la liste des départements initiale, 
	 * puis lit le fichier .csv des départements de l'insee pour créer une liste de départements avec les noms et les codeRegion
	 * enfin, complete la liste initiale en ajoutant les noms et les codeRegions.
	 *  
	 * @throws IOException 
	 */
	private void initListDpts() throws IOException {
		Departement deptToTest = null;
		for (Ville ville : this.listVilles) {
			deptToTest = new Departement(ville.getCodeDept(), "", "", 0L);		
			if(!this.listDpts.contains(deptToTest)) {
				this.listDpts.add(deptToTest);
			}			
		}
		List<String> listString = new ArrayList<>();
		listString = readDeptFile();
		ArrayList<Departement> listFromCsv = new ArrayList<>();
		for (String line : listString) {
			String[] tabOneLine = line.split(",");
			Departement dept = new Departement(tabOneLine[0], tabOneLine[1], tabOneLine[5], 0L);
			listFromCsv.add(dept);
		}
		for (Departement deptList : this.listDpts) {
			for (Departement deptCsv : listFromCsv) {
				if (deptList.equals(deptCsv)) {
					deptList.setCodeReg(deptCsv.getCodeReg());
					deptList.setNomDept(deptCsv.getNomDept());
				}
			}
		}
	}
	
	
	/**
	 * Méthode qui teste si le fichier .csv de l'insee des departements existe, qu'il est un fichier et qu'il est accessible en lecture,
	 * si oui : retourne une liste de String issue de readAllLines, 
	 * si non : retourne null. 
	 * 
	 * @return liste de String issue de readAllLines ou null. 
	 * @throws IOException
	 */
	private List<String> readDeptFile() throws IOException {
		Path path = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fr/diginamic/recensement/files/departement_2022.csv");
		boolean isFile = Files.isRegularFile(path);
		boolean isReadable = Files.isReadable(path);
		boolean isFileExists = Files.exists(path);
		
		if(!isFileExists || !isFile || !isReadable) {
			return null;
		}
		else {
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.remove(0);
			return lines;
		}
	}

	/**
	 * Méthode qui collecte les régions depuis la liste des villes et construit la liste des régions. 
	 * 
	 */
	private void initListRegions() {
		Region regionToTest = null;
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
		Path path = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fr/diginamic/recensement/files/recensement-modif-Lyon.csv");
		boolean isFile = Files.isRegularFile(path);
		boolean isReadable = Files.isReadable(path);
		boolean isFileExists = Files.exists(path);
		if(!isFileExists || !isFile || !isReadable) {
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
