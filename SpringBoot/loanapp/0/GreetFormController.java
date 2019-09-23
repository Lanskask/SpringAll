package ru.smurtazin.loan.loanapp.controllers;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.smurtazin.loan.loanapp.models.Loan;
import ru.smurtazin.loan.loanapp.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@Log4j
public class GreetFormController {

    @GetMapping("application_loan")
    public String greetingForm(Model model, Locale loc) {
//        InetAddressLocator.getlocale()
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String ip = request.getRemoteAddr();
        model.addAttribute("loan", new Loan());
        model.addAttribute("user", new User());
        model.addAttribute("contry", loc.getCountry());

        /*String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            System.out.println("Country Code = " + obj.getCountry()
                    + ", Country Name = " + obj.getDisplayCountry());
        }*/

        return "application_loan";
    }

    @PostMapping("application_loan")
    public String greetingSubmit(@ModelAttribute Loan Loan) {
        return "result";
    }

}
