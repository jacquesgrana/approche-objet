package tp9.exoInterface;

public class TestObjetGeometrique {

	public static void main(String[] args) {
		
		Cercle monCercle = new Cercle(150.0d);
		Rectangle monRectangle = new Rectangle(150.0d, 300.0d);
		
		ObjetGeometrique[] myTab = {monCercle, monRectangle};
		
		for (int i=0; i<myTab.length; i++) {
			System.out.println("\n" + i + " : " + myTab[i].toString() + " Périmètre : " + myTab[i].perimetre() + " Surface : " + myTab[i].surface());
		}

	}

}
