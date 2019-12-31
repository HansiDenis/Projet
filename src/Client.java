public class Client {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String email;
    private String telephone;
    private int duree;
    private double note;
    private int tickets;
    private int gains;
    private int jetons;
    private boolean presence = true;
    private int abroad = 0;

    /**
     * @param name      le nom de famille du client
     * @param firstName le prénom du client
     * @param birth     la date de naissance du client
     * @param mail      l'adresse e-mail du client
     * @param phone     le numéro de téléphone du client
     * @param ind       l'indice téléphonique du client
     * @param time      la durée du séjour du client
     */
    //test validite naissance, email, tel
    public Client(String name, String firstName, String birth, String mail, String phone, String ind, int time) {
        nom = name;
        prenom = firstName;
        note = 0.0;
        gains = 0;
        jetons = 20;

        if (time >= 0) {
            duree = time;
        } else {
            System.out.println("Durée renseignée incorrecte");
            duree = 0;
        }
        if (birth.matches("[0-3]+[0-9]+/[0 1]+[0-9]+/[1 2]+[0 9]+[0-9]+[0-9]+")) {
            dateNaissance = birth;
        } else {
            System.out.println("Date de naissance invalide M(Mme): " + this.nom);
        }

        if ((mail.indexOf('.', mail.indexOf("@")) != -1) && (mail.contains("@"))) {
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
        tickets = duree;
    }

    public boolean getPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Client() {
        this("non renseigné", "renseigné", "01/01/1000", "non@f.df", "0000000000", "", 0);
    }

    public int getAbroad() {
        return abroad;
    }

    public void setAbroad(int abroad) {
        if (abroad > 9) {
            this.abroad = 0;
            this.setPresence(true);
        } else {
            this.abroad = abroad;
        }
    }

    public void setDuree(int duree) {
        this.duree = Math.max(duree, 0);
    }

    public int getGains() {
        return gains;
    }

    public void setGains(int gains) {
        this.gains = gains;
    }

    public int getJetons() {
        return jetons;
    }

    public void setJetons(int jetons) {
        this.jetons = jetons;
    }

    public void affichage() {
        System.out.println("Nom et prénom du client : " + this.nom + " " + this.prenom + "\n e-mail : " + this.email + "\nTélephone : " + this.telephone);
    }

    public int getDuree() {
        return duree;
    }

    public String getNom() {
        return this.nom;
    }



    public String getNaissance() {
        return this.dateNaissance;
    }


    public String getEmail() {
        return this.email;
    }


    public String getTel() {
        return this.telephone;
    }


    public int getTickets() {
        return tickets;
    }

    public void setTickets() {
        this.tickets = tickets - 1;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
