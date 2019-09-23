package ru.smurtazin.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

  @Autowired
  private BeerRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.findAll().forEach(System.out::println);

    Stream.of(
        "Kentucky Brunch Brand Stout",
        "Marshmallow Handjee",
        "Floyds Brewing Co.",
        "Barrel-Aged Abraxas",
        "King Julius",
        "Hunahpu's Imperial Stout - Double Barrel Aged",
        "Heady Topper",
        "Very Hazy",
        "King JJJuliusss",
        "Drie Fonteinen Zenne Y Frontera",
        "Fundamental Observation",
        "SR-71"
    ).forEach(name ->
        repository.save(new Beer(name))
    );
  }

}
