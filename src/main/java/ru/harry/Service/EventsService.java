package ru.harry.Service;

import java.util.List;
/**
 * Service interface for {Events} class.
 * @author HarryPC
 * @version 1.0
 */
public interface EventsService<T> {

    List<T> getAll();
    T getById(Long id);
    void save(T customer);
    void delete(Long id);

}
