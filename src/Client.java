public class Client {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String email;
    private String telephone;

    public Client() {
        this("non renseigné", "non renseigné", "non renseigné", "non renseigné", "non renseigné", "non renseigné");
    }

    //test validite naissance, email, tel
    public Client(String name, String firstName, String birth, String mail, String phone, String ind) {
        nom = name;
        prenom = firstName;

        if (birth.matches("[0-3]+[0-9]+/[0 1]+[0-9]+/[1 2]+[0 9]+[0-9]+[0-9]+")) {
            dateNaissance = birth;
        } else {
            System.out.println("Date de naissance invalide M(Mme): " + this.nom);
        }

        if ((mail.indexOf('.', mail.indexOf("@")) != -1) && (mail.indexOf("@") != -1)) {
            email = mail;
        } else {
            System.out.println("Adresse e-mail invalide M(Mme) : " + this.nom);
        }

        if ((phone.length() == 10) && (phone.matches("[0-9]*"))) {
            if (ind.matches("\\+[0-9]+[0-9]+")) {
                telephone = ind + phone.substring(1);
            } else {
                telephone = phone;
            }
        } else {
            System.out.println("Numéro de téléphone invalide M(Mme) : " + this.nom);
        }
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
