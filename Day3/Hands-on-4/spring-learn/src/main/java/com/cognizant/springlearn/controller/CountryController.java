package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception;

import javax.validation.*;


@RestController
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public CountryController() {
		// TODO Auto-generated constructor stub
		LOGGER.info("Inside CountryController Constructor");
	}

	@RequestMapping(value = "/country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		return country;
	}
	
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> array =  context.getBean("countryList", java.util.ArrayList.class);
		return array;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws exception {
		CountryService cs = new CountryService();
		Country country = cs.getCountry(code);
		return country;
	}
	
//	@PostMapping("/countries")
//	public void addCountry() {
//		LOGGER.info("addCountry() START");
//		
//	}
//	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("addCountry() START");

		
//		 Create validator factory
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        // Validation is done against the annotations defined in country bean
//        Set<ConstraintViolation<Country>> violations = validator.validate(country);
//        List<String> errors = new ArrayList<String>();
//
//        // Accumulate all errors in an ArrayList of type String
//        for (ConstraintViolation<Country> violation : violations) {
//            errors.add(violation.getMessage());
//        }
//
//        // Throw exception so that the user of this web service receives appropriate error message
//        if (violations.size() > 0) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//        }

		LOGGER.info(country.toString());
		return country;
	}
}
	