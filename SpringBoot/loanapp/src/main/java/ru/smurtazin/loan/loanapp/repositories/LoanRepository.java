package ru.smurtazin.loan.loanapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.smurtazin.loan.loanapp.models.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long> {

}
