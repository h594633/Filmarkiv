package no.hvl.dat102;

public class KlientBSTre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KjedetBSTre bstre = new KjedetBSTre();

		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);

		// Tester på sortert utskrift
		System.out.println("Skriver ut elementene sortert i bs-treet");
		bstre.visInorden();
		System.out.println("Minste verdi: " + bstre.finnMin());
		System.out.println("Storste verdi: " + bstre.finnMaks());
		if(bstre.finn2(3) != null){
			System.out.println(3 + " finnes i treet");
		} else {
			System.out.println(3 + " finnes ikke");
		}
		System.out.println(bstre.hoydeRek(bstre.getRot()));
		bstre.fjernMin();
		bstre.visInorden();
		bstre.fjernMaks();
		bstre.visInorden();
		// Tester på om et bestemt element fins
		int element = 8;
		System.out.println("\nTester paa om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}

		element = 1;
		System.out.println("\nTester paa om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}
	}

}
