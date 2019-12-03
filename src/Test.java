import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        HashMap<Integer, String[]> list = new HashMap<Integer, String[]>();
        list.put(1, new String[]{"pair", "noir"});
        Client c = new Client("Maltese", "Salomé", "10/03/2000", "salome.maltes@gmail.com", "0619310708", "+33");
        Hotel h = new Hotel();
        System.out.println(list.get(1)[1]);
        h.reservation(1, c, 1, "double");
        h.ticket(c);
        h.affichage();
        Casino
    }
}