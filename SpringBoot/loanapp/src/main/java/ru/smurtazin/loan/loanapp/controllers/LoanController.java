package ru.smurtazin.loan.loanapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.smurtazin.loan.loanapp.models.Loan;
import ru.smurtazin.loan.loanapp.repositories.LoanRepository;

import java.sql.Date;

@Controller
@RequestMapping(path="/loan")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewLoan(@RequestParam Long amount, @RequestParam String termEnd) {
        Loan l = new Loan();
//        l.setUser(thisUser);
        l.setAmount(amount);
        l.setTermEnd(Date.valueOf(termEnd));
        loanRepository.save(l);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }
}
