public class Chambre {
    private String type;


    public Chambre() {
        this(null);
    }

    //rappeler pq pas de test
    public Chambre(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public double Prix() {
        switch (this.type) {
            case "simple":
                return 124.70 + (14.0 / 100.0) * 124.70;
            case "double":
                return 137.60 + (14.0 / 100.0) * 137.60;
            case "triple":
                return 163.40 + (14.0 / 100.0) * 163.40;
            case "deluxe":
                return 189.20 + (14.0 / 100.0) * 189.20;
            default:
                return 0;
        }
    }

}
