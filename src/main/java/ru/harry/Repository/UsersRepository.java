package ru.harry.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.harry.Entity.UsersEntity;

/**
 * Repository interface for {@link UsersEntity} class.
 *
 * @author HarryPC
 * @version 1.0
 */
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {}
