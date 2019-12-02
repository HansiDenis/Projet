package Hotel;

public class Test {

	public static void main(String[] args) {

		Client c = new Client();
		Hotel h = new Hotel();
		h.affichage();
		h.reservation(c);
	}
}
