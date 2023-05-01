package com.example.WebDev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class EventRepository {

    // using HashMap as temporary database
    HashMap<Integer, Event> eventHashMap = new HashMap<>();

    // write APIs here

    public int addEvent(Event event) {

        // add an event here

        int key = Event.getInstances();

        eventHashMap.put(key, event);

        return key;
    }

    public Event getEventById(Integer event_id) {

        // return event from eventHashMap
        return eventHashMap.containsKey(event_id) ? eventHashMap.get(event_id) : null;
    }

    public void updateEvent(Integer id, Event event) {

        // update event in eventHashMap

        eventHashMap.put(id, event);
    }

    public void deleteEvent(Integer id) {

        // delete event by its id
        eventHashMap.remove(id);
    }

    public List<Event> getAllEvents() {

        List<Event> eventList = new ArrayList<>(); // latest first

        // the latest key / event will the eventInstanceNo
        for (int key = Event.getInstances(); key >= 0; key--) {

            Event event = eventHashMap.get(key);
            eventList.add(event);
        }

        return eventList;
    }
}
