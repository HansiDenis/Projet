public class Test {

    public static void main(String[] args) {
        Client c = new Client("Maltese", "Salomé", "10/03/2000", "salome.maltes@gmail.com", "0619310708", "+33");
        Hotel h = new Hotel();
        h.reservation(1, c, 1, "double");
        h.ticket(c);
        h.affichage();
        Casino casino = new Casino();
        casino.create();
    }
}