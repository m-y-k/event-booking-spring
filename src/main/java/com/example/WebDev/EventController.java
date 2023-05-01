package com.example.WebDev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/app")
public class EventController {

    @Autowired
    EventService eventService;


    // API - 1 & 2
    @GetMapping("/events")
    public Event getEventById(@RequestParam(value = "id", required = false) String event_id,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "limit", required = false) Integer limit,
                              @RequestParam(value = "page", required = false) Integer page) {

        if (event_id == null) {
            if (type != null && limit != null && page != null) {
                return eventService.getEventByParameters(type, limit, page);
            }
        }
        else {
            int id = Integer.parseInt(event_id.substring(1));
            return eventService.getEventById(id);
        }
        return null;
    }


    // API - 3
    @PostMapping("/events")
    public int addEvent(@RequestBody Event event) {

        return eventService.addEvent(event);
    }

    // API - 4
    @PutMapping("/events/:{id}")
    public void updateEvent(@PathVariable("id") Integer id,
                            @RequestBody Event event) {

        // update the event in the repository class
        eventService.updateEvent(id, event);

    }

    // API - 5
    @DeleteMapping("/events/:{id}")
    public void deleteEvent(@PathVariable("id") Integer id) {

        eventService.deleteEvent(id);
    }

}
