package fichier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreerFichier {

	public static void main(String[] args) throws IOException {
		
		Path pathSource = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fichier/files/recensement.csv");
		Path pathDestination = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fichier/files/recensement_100ligne.csv");
		
		List<String> lines = Files.readAllLines(pathSource, StandardCharsets.UTF_8);
		List<String> lineDest = new ArrayList<>();
		
		int compteur = 1;
		for (String line: lines) {
			if(compteur <= 100) {
				lineDest.add(line);
				System.out.println(compteur + " / " + line);
			}
			compteur++;
		}
		
		Files.write(pathDestination, lineDest, StandardCharsets.UTF_8);
		

	}

}
