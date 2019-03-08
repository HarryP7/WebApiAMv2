package ru.harry.Service;

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
    final
    EventsRepository eventsRepo;

    @Autowired
    public EventsServiceImpl(EventsRepository eventsRepo) {
        this.eventsRepo = eventsRepo;
    }

    @Override
    public List<EventsEntity> getAll() {
        return eventsRepo.findAll();
    }
    @Override
    public EventsEntity getById(Long id) {
        return eventsRepo.findOne(id);
    }
    @Override
    public void save(EventsEntity entity) {
        eventsRepo.save(entity);
    }
    @Override
    public void delete(Long id) {
        eventsRepo.delete(id);
    }
}
