package ru.smurtazin.spring.simpleweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.smurtazin.spring.simpleweb.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
