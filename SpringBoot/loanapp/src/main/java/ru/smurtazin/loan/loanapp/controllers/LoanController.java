package ru.smurtazin.loan.loanapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.smurtazin.loan.loanapp.models.Loan;
import ru.smurtazin.loan.loanapp.repositories.LoanRepository;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(path = "/loans")
public class LoanController extends CommonController<Loan> {

    @Autowired
    private LoanRepository repository;

    @PostConstruct
    public void init() {
        super.setThisRepository((CrudRepository) repository);
    }

}
