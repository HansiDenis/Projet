public class Spa {

    public int prix;
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

    public void calculPrix() {
        prix = prix + Relaxant * 50 + PierresChaudes * 70 + ElixirBougie * 80;
    }

    public void affichePrix() {
        this.calculPrix();
        System.out.println("Coût total : " + prix + "€");
    }
}
