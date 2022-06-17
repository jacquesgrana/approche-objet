package fichier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectureFichier {

	public static void main(String[] args) throws IOException{
		
		ArrayList<Ville> listeVilles = new ArrayList<>();
		Path path = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fichier/files/recensement.csv");
		
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);
		for (String line: lines) {
			String[] tabOneLine = line.split(";");
			
			
			//System.out.println("nom : " + tabOneLine[6] + " dep : " + tabOneLine[2] + " reg : " + tabOneLine[1] + " pop : " + tabOneLine[9].replace(" ", ""));
			Ville ville = new Ville(tabOneLine[6], tabOneLine[2], tabOneLine[1], Integer.parseInt(tabOneLine[9].replace(" ", "")));
			listeVilles.add(ville);
			//System.out.println(ville.toString());
		}
		
		System.out.println("\n\n");
		
		for (Ville ville : listeVilles) {
			System.out.println(ville.toString());
		}

	}

}
