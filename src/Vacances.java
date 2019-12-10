import java.util.Scanner;

public class Vacances {
    private Hotel hotel;
    private String lieu;
    private String date;

    public Vacances(Hotel hotel) {
        hotel = new Hotel();
    }


    public String demlieu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quel est le lieu?");
        String n = sc.nextLine();
        return n;
    }

    public String dem() {
        Scanner sc = new Scanner(System.in);
        demlieu();
        System.out.println("Quelle sera la date?");
        String n = sc.nextLine();
        return demlieu() + n;
    }
}
