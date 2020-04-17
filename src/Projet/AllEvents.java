package Projet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AllEvents {
    HashMap<String, Event> events;

    AllEvents(ArrayList<Event> events) {
        this.events = new HashMap<>();
        for (Event event : events) {
            this.events.put(event.reference(), event);
        }
    }

    ArrayList<String> typeSearch(String type) {
        ArrayList<String> found = new ArrayList<>();
        if (type.equals("sport")) {
            Iterator it = this.events.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry event = (Map.Entry) it.next();
                if (event.getValue() instanceof SportEvent) {
                    found.add((String) event.getKey());
                }

            }
        }
        return found;
    }
}
