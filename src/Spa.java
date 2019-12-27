public class Spa {


    public double prix;
    private int Relaxant;
    private int PierresChaudes;
    private int ElixirBougie;

    public Spa(int r, int pc, int eb, int p) {
        this.Relaxant = r;
        this.PierresChaudes = pc;
        this.ElixirBougie = eb;
        this.prix = p;
    }

    public Spa() {
        this(0, 0, 0, 0);
    }

    public void afficheTarifs() {
        System.out.println("     Tarifs du Spa     \nMassage relaxant : 50€\nMassage aux pierres chaudes : 70€\nMassage à l'elixir de bougie : 80€");
    }

    public double Prix(String rep) {
        switch (rep) {
            case "relaxant":
                return prix = 50;
            case "pierres":
                return prix = 70;
            case "elixir":
                return prix = 80;
            default:
                System.out.println("Mauvais type de massage renseigné.");
                return prix = 0;
        }
    }

    public void affichePrix() {
        System.out.println("Coût du massage : " + prix + "€");
    }
}
