package ru.smurtazin.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class BeerController {

  @Autowired
  private BeerRepository repository;

  @GetMapping("/beers")
  @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
  public List<Beer> read() {
    return repository.findAll();
  }

  @GetMapping("/payment-go")
  public void sendToPayment(HttpServletResponse response) throws IOException {
    response.sendRedirect("payment.html");
  }

}
