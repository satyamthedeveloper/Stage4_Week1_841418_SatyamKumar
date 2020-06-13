package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception;

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
}
	