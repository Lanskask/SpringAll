package ru.smurtazin.loan.loanapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.smurtazin.loan.loanapp.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
