package utils;

public class TestMethodeStatic {

	public static void main(String[] args) {
		String myString = "124";
		int intValue  = Integer.parseInt(myString);
		
		System.out.println("String : " + myString + " / Int : " + intValue);
		
		int a=5, b=2;
		int myMax = Integer.max(a, b);
		
		System.out.println();
		System.out.println(" a : " + a + " / b : " + b + " / max : " + myMax);
	}

}
