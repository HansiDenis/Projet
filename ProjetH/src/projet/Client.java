package projet;

public class Client {

	private String nom;
	private String prenom;
	private String dateNaissance;
	private String email;
	private String telephone;

	public Client() {
		this("non renseigné", "non renseigné", "non renseigné", "non renseigné", "non renseigné");
	}

	//test validite naissance, email, tel
	public Client(String nom, String prenom, String naissance, String email, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = naissance;
		this.email = email;
		this.telephone = tel;
	}

	public void affichage() {
		System.out.println("Nom et prénom du client : " + this.nom + " " + this.prenom + "\ne-mail : " + this.email + "\nTélephone : " + this.telephone);
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String n) {
		this.nom = n;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String p) {
		this.prenom = p;
	}

	public String getNaissance() {
		return this.dateNaissance;
	}

	public void setNaissance(String date) {
		this.dateNaissance = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public String getTel() {
		return this.telephone;
	}

	public void setTel(String numero) {
		this.telephone = numero;
	}

}

