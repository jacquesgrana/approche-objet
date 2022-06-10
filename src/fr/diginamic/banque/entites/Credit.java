package fr.diginamic.banque.entites;

public class Credit extends Operation{

	public Credit(String dateOper, float montantOper) {
		super(dateOper, montantOper);
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return "CREDIT";
	}
	
	

}
