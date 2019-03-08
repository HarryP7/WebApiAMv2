package ru.harry.REST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(EventsRestController.class);

    private final EventsService eventsService;

    @Autowired
    public EventsRestController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<EventsEntity>> getAllEvents() {
        log.info("IN EventsService getAll");
        List events = this.eventsService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> getEvent(@PathVariable("id") Long id) {
        log.info("IN EventsService getById {}", id);
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
    public ResponseEntity<EventsEntity> insertEvent(@RequestBody @Valid EventsEntity events) {
        log.info("IN EventsService insert {}", events);
        HttpHeaders headers = new HttpHeaders();

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.eventsService.save(events);
        return new ResponseEntity<>(events, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> updateEvent(@RequestBody @Valid EventsEntity events, UriComponentsBuilder builder) {
        log.info("IN EventsService update {}", events);
        HttpHeaders headers = new HttpHeaders();

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.eventsService.save(events);
        return new ResponseEntity<>(events, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventsEntity> deleteCustomer(@PathVariable("id") Long id) {
        log.info("IN EventsServiceImpl delete {}", id);
        EventsEntity events = (EventsEntity) this.eventsService.getById(id);

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
