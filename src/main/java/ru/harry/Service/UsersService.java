package ru.harry.Service;
import java.util.List;
/**
 * Service interface for {Users} class.
 * @author HarryPC
 * @version 1.0
 */
public interface UsersService<T> {
    List<T> getAll();
    T getById(Long id);
    void save(T customer);
    void delete(Long id);
}
