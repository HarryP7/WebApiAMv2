package ru.harry.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.harry.Entity.EventsEntity;
import ru.harry.Repository.EventsRepository;
import java.util.List;
/**
 * Implementations of {@link EventsService} interface.
 * @author HarryPC
 * @version 1.0
 */

@Service
public class EventsServiceImpl implements EventsService<EventsEntity> {
    private static final Logger log = LoggerFactory.getLogger(EventsServiceImpl.class);
    @Autowired
    EventsRepository eventsRepo;

    @Override
    public List<EventsEntity> getAll() {
        log.info("IN EventsServiceImpl getAll");
        return eventsRepo.findAll();
    }
    @Override
    public EventsEntity getById(Long id) {
        log.info("IN EventsServiceImpl getById {}", id);
        return eventsRepo.findOne(id);
    }
    @Override
    public void save(EventsEntity entity) {
        log.info("IN EventsServiceImpl save {}", entity);
        eventsRepo.save(entity);
    }
    @Override
    public void delete(Long id) {
        log.info("IN EventsServiceImpl delete {}", id);
        eventsRepo.delete(id);
    }
}
