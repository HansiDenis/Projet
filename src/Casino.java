import java.util.HashMap;

public class Casino {
    public static HashMap<Integer, String[]> Roulette = new HashMap<Integer, String[]>(37);

    public void create() {
        Roulette.put(0, new String[]{"zéro", "vert"});
        for (int i = 1; i <= 36; i++) {
            if (i <= 10) {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "noir"});
                } else {
                    Roulette.put(i, new String[]{"impair", "rouge"});
                }
            } else if (i > 10 && i <= 18) {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "rouge"});
                } else {
                    Roulette.put(i, new String[]{"impair", "noir"});
                }
            } else if (i > 18 && i <= 28) {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "noir"});
                } else {
                    Roulette.put(i, new String[]{"impair", "rouge"});
                }
            } else {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "rouge"});
                } else Roulette.put(i, new String[]{"impair", "noir"});
            }
        }
        /**for (int i=0;i<=36;i++){
         System.out.println(Arrays.toString(Roulette.get(i)));
         }**/
    }
}
