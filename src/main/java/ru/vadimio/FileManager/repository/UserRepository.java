package ru.vadimio.FileManager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vadimio.FileManager.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Short> {

    User findOneByLogin(String login);

}