package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.function.Supplier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.Country;

@Service
public class CountryService {

	public Country getCountry(String Code) throws exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countires = context.getBean("countryList", java.util.ArrayList.class);

//		method 1:
//		for(Country country: countries) {
//			if(country.getCode().equalsIgnoreCase(Code))
//				return country;
//			};
//		
//		method 2:
		
		return countires.stream().filter(country -> country.getCode().equalsIgnoreCase(Code)).findFirst().orElseThrow(
				() -> new exception());
	
	
	}
}