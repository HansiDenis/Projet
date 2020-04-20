package events;

public class Party extends Event {

   String kind; //genre pour carnaval ou anniversaire
   String theme;
   int age; //pour anniv

    Party(int start, int end, String place, String name, String kind, String th, int age) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.theme = th;
        this.type = "party";
        this.kind = kind;
        if (kind.equals("anniversaire")) {
            this.age = age;
        }
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    public void present() {
        super.present();
        System.out.println("Venez avec nous célebrer ce(t)" + this.kind + ".\n"
                + "Le thème de la fête est " + this.theme + ".");
        if (this.kind.equals("anniversaire")) {
            System.out.println("On vous invite à célebrer ses " + this.age + " ans.");
        }
    }


    @Override
    public String reference() {
        if (name.length() <= 2) {
            return "PE-" + this.kind + eventNumber + "-" + this.start + "-" + this.end;
        }
        return "PE-" + this.kind.substring(0, 2) + eventNumber + "-" + this.start + "-" + this.end;
    }
}