package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;

	@GetMapping
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> countryList = (List<Country>) context.getBean("countryList");
		LOGGER.info("END");
		return countryList;
	}

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		Country result = countryService.getCountry(code);
		LOGGER.info("END");
		return result;
	}

	@PostMapping
	public Country addCountry(@RequestBody Country country) {
		LOGGER.info("Start");
		LOGGER.info("Country : {}", country.toString());

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Country>> violations = validator.validate(country);
		List<String> errors = new ArrayList<String>();

		for (ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}

		if (violations.size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
		}

		return country;
	}

}