package edu.spring.rest;

import edu.spring.domain.Country;
import edu.spring.repostory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository repository) {
        this.countryRepository = repository;
    }

    @PostMapping(value = "/countries")
    public ResponseEntity<Country> addCountry(@RequestParam("name") String name) {
        return new ResponseEntity<>(countryRepository.save(new Country(name))
                , HttpStatus.OK);
    }

    @GetMapping(value = "/countries/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Integer id) {
        return new ResponseEntity<>(countryRepository.findById(id)
                .orElseThrow(NotFoundException::new)
                , HttpStatus.OK);
    }

    @PutMapping(value = "/countries/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Integer id, @RequestParam("name") String name) {
        var country = countryRepository.findById(id).orElseThrow(NotFoundException::new);
        country.setName(name);
        return new ResponseEntity<>(countryRepository.save(country)
                , HttpStatus.OK);
    }

    @DeleteMapping(value = "/countries/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Integer id) {
        return new ResponseEntity<>(countryRepository.findById(id).orElseThrow(NotFoundException::new)
                , HttpStatus.OK);
    }
}
