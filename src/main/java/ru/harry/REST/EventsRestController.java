package ru.harry.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.harry.Entity.EventsEntity;
import ru.harry.Service.EventsService;
import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for {@link EventsEntity} connected requests.
 * @author HarryPC
 * @version 1.0
 */

@RestController
@RequestMapping("/api/events/")
public class EventsRestController {

    @Autowired
    private EventsService eventsService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<EventsEntity>> getAllEvents() {
        List events = this.eventsService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> getEvent(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventsEntity entity = (EventsEntity) this.eventsService.getById(id);

        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> saveEvent(@RequestBody @Valid EventsEntity events) {
        HttpHeaders headers = new HttpHeaders();

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.eventsService.save(events);
        return new ResponseEntity<>(events, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> updateEvent(@RequestBody @Valid EventsEntity events, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.eventsService.save(events);
        return new ResponseEntity<>(events, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> deleteCustomer(@PathVariable("id") Long id) {
        EventsEntity events = (EventsEntity) this.eventsService.getById(id);

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
