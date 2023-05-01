package com.example.WebDev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public int addEvent(Event event) {

        return eventRepository.addEvent(event);
    }

    public Event getEventById(Integer event_id) {

        return eventRepository.getEventById(event_id);
    }

    public void updateEvent(Integer id, Event event) {

        // set eventId as id in event object
        if (event != null) {
            event.setEvent_id(id);
        }


        // update the event in the repository class
        eventRepository.updateEvent(id, event);

        // also decrease the count of eventInstances because for updating an event was formed
        int currentValue = Event.getInstances();
        Event.setInstances(currentValue - 1);
    }

    public void deleteEvent(Integer id) {

        eventRepository.deleteEvent(id);
    }

    public Event getEventByParameters(String type, Integer limit, Integer page) {

        // get all events list from repository layer
        // filter required / asked events
        // and send back to controller layer

        List<Event> eventList = eventRepository.getAllEvents();
        // 0 -> n - 1 = 4

        // filter by recency, limit and page
        // page - 2  ->  limit - 5
        // so the required index will be -> limit * page

        int index = limit * page;
        // index = 5 -> index + limit -- 5 + 5 = 10

        // this index - limit will give latest event on a page
        Event event = eventList.get(index - limit);

        return event;
    }
}
