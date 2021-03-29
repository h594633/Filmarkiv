package no.hvl.dat107;

/**
 * 
 * @author erikf
 *
 */
public class EtLiteMainProgramm {

	public static void main(String[] args) {
		AnsattDAO ansatt = new AnsattDAO();
		
		

		Ansatt ans1 = ansatt.finnAnsattMedId(1);
		Ansatt ans3 = ansatt.finnAnsattMedId(2);
		Ansatt ans2 = ansatt.finnAnsattMedId(3);
		Ansatt ans4 = ansatt.finnAnsattMedId(4);
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		System.out.println(ans4);

		
		boolean running = true;
		
		
/**
		1 Søke etter ansatt på ansatt-id
		2 Søke etter ansatt på brukernavn (initialer)
		3 Utlisting av alle ansatte
		4 Oppdatere en ansatt sin stilling og/eller lønn
		5 Legge inn en ny ansatt
		6 avslutte
 */
		
		while (running) {
			String userInput = javax.swing.JOptionPane.showInputDialog("tast 1 for");
			int value = Integer.parseInt(userInput);
			
			switch (value) {
			case 1: {
				
				running = false;
				javax.swing.JOptionPane.showMessageDialog(null, "Programmet lukkes");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + userInput);
			}
		}
		
	}
}
