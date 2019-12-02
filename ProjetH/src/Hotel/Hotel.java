import java.text.*;
import java.util.Date;
import java.util.Scanner;

package Hotel;

public class Hotel {

	private static int[] numChambre = new int[40];
	private Client[] client;
	private Chambre[] chambres;
	private int nbSimple;
	private int nbDouble;
	private int nbTriple;
	private int nbDeluxe;
	private String[] disponibilite;

	public Hotel() {
		this(10, 10, 10, 10);
	}

	//Test validite nb total = 100
	public Hotel(int nbSimple, int nbDouble, int nbTriple, int nbDeluxe) {
		this.nbSimple = nbSimple;
		this.nbDouble = nbDouble;
		this.nbTriple = nbTriple;
		this.nbDeluxe = nbDeluxe;
		chambres = new Chambre[40];
		disponibilite = new String[40];
		client = new Client[40];
		for (int i = 0; i < nbSimple; i++) {
			this.chambres[i] = new Chambre("simple");
		}
		for (int i = 0; i < nbDouble; i++) {
			this.chambres[nbSimple + i] = new Chambre("double");
		}
		for (int i = 0; i < nbTriple; i++) {
			this.chambres[nbSimple + nbDouble + i] = new Chambre("triple");
		}
		for (int i = 0; i < nbDeluxe; i++) {
			this.chambres[nbSimple + nbDouble + nbTriple + i] = new Chambre("deluxe");
		}
		for (int i = 0; i < 40; i++) {
			disponibilite[i] = "libre";
			numChambre[i] = i + 1;
		}

	}

	public void affichage() {
		for (int i = 0; i < 40; i++) {
			String c = "";
			if (client[i] == null) {
				c = "aucun";
			} else {
				c = client[i].getNom();
			}
			System.out.println(numChambre[i] + "               " + chambres[i].getType() + "               " + disponibilite[i] + "               " + c);
		}
	}

	public boolean type(String type) {
		boolean b = true;
		int max = 0;
		//while(b){
		//System.out.println("Quel type de chambre voulez-vous réserver ?(simple/double/triple/deluxe)");
		switch (type) {
			case "simple":
				max = 1;
				b = false;
				break;
			case "double":
				max = 2;
				b = false;
				break;
			case "triple":
				max = 3;
				b = false;
				break;
			case "deluxe":
				max = 2;
				b = false;
				break;
			default:
				System.out.println("Mauvais type de chambre renseigné");
				break;
			//}
		}
	}

	public int[] reservation(int max, Client C) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Combien de personnes occuperont la chambre?");
		int n = sc.nextInt();
		if (n > max) {
			System.out.println("Vous ne pouvez pas être autant que ça dans cette chambre, veuillez réaliser une nouvelle réservation.");
			return false;
		} else {
			return true;
		}
	}

	public void ticket() {
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("d MMMM yyyy, H:m:s");
		System.out.println("**********HOTEL BLUE BAY CARACAO**********\n\nDate de réservation : " + formater.format(date) + "\n");
		//Client.affichage();
	}


}
