package ru.harry.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.harry.Entity.UsersEntity;
import ru.harry.Repository.UsersRepository;

import java.util.List;

/**
 * Implementations of {@link UsersService} interface.
 * @author HarryPC
 * @version 1.0
 */

@Service
public class UsersServiceImpl implements UsersService<UsersEntity> {
    private final UsersRepository usersRepo;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public List<UsersEntity> getAll() {
        return usersRepo.findAll();
    }
    @Override
    public UsersEntity getById(Long id) {
        return usersRepo.findOne(id);
    }
    @Override
    public void save(UsersEntity entity) {
        usersRepo.save(entity);
    }
    @Override
    public void delete(Long id) {
        usersRepo.delete(id);
    }
}
