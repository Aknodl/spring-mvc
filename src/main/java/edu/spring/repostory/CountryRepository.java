package edu.spring.repostory;

import edu.spring.domain.Country;
import edu.spring.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

    List<Country> findAll();
}
