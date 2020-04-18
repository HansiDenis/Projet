package Projet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AllEvents {
    HashMap<String, Event> events;

    AllEvents(ArrayList<Event> events) {
        this.events = new HashMap<>();
        for (Event event : events) {
            this.events.put(event.reference(), event);
        }
    }

    AllEvents() {
        this.events = new HashMap<>();
    }

    void addEvent(Event event) {
        this.events.put(event.reference(), event);
    }

    ArrayList<Event> refSearch(ArrayList<String> wanted) {
        ArrayList<Event> found = new ArrayList<>();
        for (String want : wanted) {
            if (this.events.get(want) != null) {
                found.add(this.events.get(want));
            }
        }
        return found;
    }

    Event refSearch(String wanted) {
        Event found = new Event() {
            @Override
            void takePlace() {
            }

            @Override
            public String reference() {
                return null;
            }
        };
        if (this.events.get(wanted) != null) {
            found = this.events.get(wanted);
        }
        return found;
    }

    ArrayList<Event> typeSearch(String type) {
        ArrayList<Event> found = new ArrayList<>();
        if (type.equals("sport")) {
            for (Map.Entry<String, Event> stringEventEntry : this.events.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof SportEvent) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("comedy")) {
            for (Map.Entry<String, Event> stringEventEntry : this.events.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Comedy) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("f&d")) {
            for (Map.Entry<String, Event> stringEventEntry : this.events.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof FoodAndDrink) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("nba")) {
            for (Map.Entry<String, Event> stringEventEntry : this.events.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof NBASeries) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        return found;
    }
}
