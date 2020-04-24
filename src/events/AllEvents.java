package events;
//Cette classe sert à la modélisation du rassemblement de tous les évènements
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AllEvents {
    /**On utilise ici un singleton qui est donc une instance de la classe déclarée static
    On fait celà car on part du postulat qu'il n'existe qu'une recollection qui contient
    tous les évènements créés**/
    private static AllEvents singleInstance = null;
    /**
     * On stock l'ensemble des évènements dans un HashMap dont les clés sont les références
     * des évènements que l'on a construit au préalable et les leurs sont les évènements eux-
     * mêmes
     */
    private static HashMap<String, Event> hashAll = new HashMap<>();
    /**
     * variable permettant de savoir si notre singleton existe déjà ou non
     */
    private static boolean notExists = true;

    /**
     *  Constructeur vide servant uniquement à la création du singleton qui est ensuite
     * modifié par les différentes classes d'évènements
     */
    AllEvents() {
    }

    /**
     * Méthode permettant de récupérer le singleton
     * @return singleInstance le singleton contenant tous les évènements à l'instant t
     */
    public static AllEvents getInstance() {
        if (notExists) {
            singleInstance = new AllEvents();
            notExists=false;
            return singleInstance;
        }
        return singleInstance;
    }

    /**
     * Méthode permettant d'ajouter un évènement unique à notre HashMap allEvents
     * @param event l'évènement que l'on souhaite ajouter à la HashMap
     */
    void addEvent(Event event) {
        AllEvents.hashAll.put(event.reference(), event);
    }

    /**
     * Méthode retournant une ArrayList des évènememts trouvés par recherche de références
     * et renvoyant une ArrayList vide sinon
     * @param wanted ArrayList des chaînes de caractères coreespondants aux références des
     *               évènements recherchés
     * @return found, la liste des évènements trouvés via la recherche(éventuellement vide)
     */
    public ArrayList<Event> refSearch(ArrayList<String> wanted) {
        ArrayList<Event> found = new ArrayList<>();
        for (String want : wanted) {
            if (hashAll.get(want) != null) {
                found.add(hashAll.get(want));
            }
        }
        return found;
    }

    /**
     * Méthode effectuant la recherche par référence et renvoyant un évènement vide sinon
     * @param wanted référence dont on veut trouver l'évènement correspondant
     * @return found,l'évènement trouvé via la recherche (éventuellement vide)
     */
    public Event refSearch(String wanted) {
        Event found = new Event() {
            @Override
            public void present() {
            }

            @Override
            public String reference() {
                return null;
            }
        };
        if (hashAll.get(wanted) != null) {
            found = hashAll.get(wanted);
        }
        return found;
    }

    /**
     * Méthode effectuant la recherche par type,on teste tous les évènements de la HashMap
     * selon le type souhaité
     * @param type Chaîne de caarctères correspondant au type souhaité
     * @return found ArrayList des évènements trouvés(éventuellement vide)
     */
    public ArrayList<Event> typeSearch(String type) {
        ArrayList<Event> found = new ArrayList<>();
        if (type.equals("sport")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof SportEvent) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("comedy")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Comedy) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("f&d")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof FoodAndDrink) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("nba")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof NBASeries) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("conference")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Conference) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("theatre")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Theatre) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("party")) {
            for (Map.Entry<String, Event> stringEventEntry : hashAll.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Party) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        return found;
    }
}
