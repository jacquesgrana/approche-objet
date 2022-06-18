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
	
	/**
	 * Vérifie l'existence du ficher, renvoie faux si fichier pas ok, sinon charge les données dans la liste et renvoie vrai
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
				//System.out.println(ville.toString());
			}
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

}
