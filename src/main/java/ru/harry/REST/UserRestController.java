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
import ru.harry.Entity.UsersEntity;
import ru.harry.Service.UsersService;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for {@link UsersEntity} connected requests.
 * @author HarryPC
 * @version 1.0
 */

@RestController
@RequestMapping("/api/users/")
public class UserRestController {
    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

    private final UsersService usersService;

    @Autowired
    public UserRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        log.info("IN UsersService getAll");
        List events = this.usersService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersEntity> getUser(@PathVariable("id") Long id) {
        log.info("IN UsersService getById {}", id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UsersEntity entity = (UsersEntity) this.usersService.getById(id);

        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersEntity> insertUser(@RequestBody @Valid UsersEntity users) {
        log.info("IN UsersService insert {}", users);
        HttpHeaders headers = new HttpHeaders();
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.usersService.save(users);
        return new ResponseEntity<>(users, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersEntity> updateUser(@RequestBody @Valid UsersEntity user, UriComponentsBuilder builder) {
        log.info("IN UsersService update {}", user);
        HttpHeaders headers = new HttpHeaders();

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.usersService.save(user);
        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersEntity> deleteUser(@PathVariable("id") Long id) {
        log.info("IN UsersService delete {}", id);
        UsersEntity events = (UsersEntity) this.usersService.getById(id);

        if (events == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
