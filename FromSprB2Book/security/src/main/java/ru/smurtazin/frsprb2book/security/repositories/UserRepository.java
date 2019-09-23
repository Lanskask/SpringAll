package ru.smurtazin.frsprb2book.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smurtazin.frsprb2book.security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}