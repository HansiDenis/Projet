package HotelBay;

public class Test {

    public static void main(String[] args) {

        Client c = new Client();
        Hotel h = new Hotel();

        h.reservation(2, c, 1, "double");
        h.ticket(c);
        h.affichage();
    }
}