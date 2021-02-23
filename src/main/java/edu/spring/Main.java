package edu.spring;

import edu.spring.repostory.PersonRepository;
import edu.spring.rest.CountryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

import javax.annotation.PostConstruct;


@EnableMapRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository repository;
    @Autowired
    private CountryController countryController;

    @PostConstruct
    public void init() {
        var entity = countryController.addCountry("France");
        int id = entity.getBody().getId();
        System.out.println(entity.getStatusCode());
        System.out.println(countryController.getCountry(id).getStatusCode());
        System.out.println(countryController.deleteCountry(id).getStatusCode());
    }

}
