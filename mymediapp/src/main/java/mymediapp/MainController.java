package mymediapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;



@RestController    // This means that this class is a Controller
@RequestMapping(path="/medi") // This means URL's start with /demo (after Application path)



@CrossOrigin(maxAge = 3600)

public class MainController {

    @Autowired
    JdbcTemplate jdbcTemplate;	
  

    @Autowired   
    RegistrationRepository registrationrepository;
	
	
    @CrossOrigin
	@PostMapping(value = "/user/demregistration",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Registration> persistPerson(@RequestBody Registration registration) {
		System.out.println("registration = "+registration);
		Registration reg = new Registration();
		reg.setEmail(registration.getEmail());
		reg.setPassword(registration.getPassword());
		reg.setConfirm(registration.getConfirm());
		reg.setForename(registration.getForename());
		reg.setSurname(registration.getSurname());
		reg.setUsername(registration.getUsername());
		reg.setCountry(registration.getCountry());
		reg.setPostcode(registration.getPostcode());
		reg.setTerms(registration.getTerms());
		return new ResponseEntity<Registration>(registrationrepository.saveAndFlush(reg), HttpStatus.OK);
    }	
	
	@GetMapping(path="/user/all")
	public @ResponseBody Iterable<Registration> getAllUsers() {
		// This returns a JSON or XML with the users
		return registrationrepository.findAll();
	}	
	
	
}
