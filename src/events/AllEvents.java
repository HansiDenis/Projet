package events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AllEvents {
    private static AllEvents singleInstance = null;
    private static HashMap<String, Event> allEvents = new HashMap<>();
    private static boolean notexists = true;

    AllEvents() {
    }

    public static AllEvents getInstance() {
        if (notexists) {
            singleInstance = new AllEvents();
            return singleInstance;
        }
        return singleInstance;
    }

    void addEvent(Event event) {
        AllEvents.allEvents.put(event.reference(), event);
    }

    public ArrayList<Event> refSearch(ArrayList<String> wanted) {
        ArrayList<Event> found = new ArrayList<>();
        for (String want : wanted) {
            if (allEvents.get(want) != null) {
                found.add(allEvents.get(want));
            }
        }
        return found;
    }

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
        if (allEvents.get(wanted) != null) {
            found = allEvents.get(wanted);
        }
        return found;
    }

    public ArrayList<Event> typeSearch(String type) {
        ArrayList<Event> found = new ArrayList<>();
        if (type.equals("sport")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof SportEvent) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("comedy")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Comedy) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("f&d")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof FoodAndDrink) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("nba")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof NBASeries) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("conference")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Conference) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("theatre")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Theatre) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        if (type.equals("party")) {
            for (Map.Entry<String, Event> stringEventEntry : allEvents.entrySet()) {
                if (((Map.Entry) stringEventEntry).getValue() instanceof Party) {
                    found.add((Event) ((Map.Entry) stringEventEntry).getValue());
                }

            }
        }
        return found;
    }
}
