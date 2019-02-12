package ru.harry.Repository;


import ru.harry.Entity.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link EventsEntity} class.
 *
 * @author HarryPC
 * @version 1.0
 */
public interface EventsRepository extends JpaRepository<EventsEntity, Long> {
}
