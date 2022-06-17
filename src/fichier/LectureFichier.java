package fichier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LectureFichier {

	public static void main(String[] args) throws IOException{
		
		Path path = Paths.get("/home/jacques/springToolsSuite/workSTS/approche-objet/src/fichier/files/recensement.csv");
		
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		for (String line: lines) {
			System.out.println(line);
		}

	}

}
