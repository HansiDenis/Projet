import java.util.HashMap;

public class Casino {
    private static HashMap<Integer, String[]> Roulette;

    public void create() {
        Roulette.put(0, new String[]{"pair", "vert"});
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
                    Roulette.put(i, new String[]{"imppair", "noir"});
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
                } else Roulette.put(i, new String[]{"imppair", "noir"});
            }
        }
    }
}
