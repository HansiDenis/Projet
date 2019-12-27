public class Plongee {

	private double nbBapteme;
	private double nbCroisiere;

	public Plongee() {
		this(0, 0);
	}

	public Plongee(int bapteme, int croisiere) {

		this.nbBapteme = bapteme;
		this.nbCroisiere = croisiere;

	}

	public void affichageTarifs() {

		System.out.println("     Tarifs de la plongée sous-marine     \n\nBaptême de plongée : 80€        Faites votre baptême de plongée sous-marine, magie garantie ! Découvrez une expérience unique sous l'eau. Encadré par l'un de nos moniteurs, vous ferez votre initiation et découvrirez la nage sous l'eau, équipé de bouteilles.\n\nCroisière plongée aux Jardins de la Reine : 550€        10 jours de croisière et 3 plongées par jour dans le parc naturel des Jardins de la Reine : ✓ La première plongée est une plongée de réa-daptation pour vous remettre dans l’eau endouceur.✓ Les Jardins de la Reine sont notamment con-nus pour les espèces de requins qu’on trouvesur place ainsi que les crocodiles, une plongéeinédite et peu courante !");

	}

	public void Prix() {

		double prixBapt = 80 * this.nbBapteme;
		double prixCrois = 550 * this.nbCroisiere;
		double tot = prixBapt + prixCrois;
		System.out.println("Plongée sous-marine « Jardins de la Reine »\n\n Nombre Baptême de plongée : " + this.nbBapteme + "x 80€ = " + prixBapt + " €\nNombre Croisière : " + this.nbCroisiere + " x 550€ = " + prixCrois + " €\n\nTotal de plongées à payer : " + tot + "€");

	}


	public double total() {

		double prixBapt = 80 * this.nbBapteme;
		double prixCrois = 550 * this.nbCroisiere;
		return prixBapt + prixCrois;
	}

}
		
