package com.ideas2it.universityManagement.controller;

import com.ideas2it.universityManagement.exception.UniversityException;
import com.ideas2it.universityManagement.model.JwtRequest;
import com.ideas2it.universityManagement.model.JwtResponse;
import com.ideas2it.universityManagement.model.University;
import com.ideas2it.universityManagement.service.UniversityServiceImpl;
import com.ideas2it.universityManagement.service.UserService;
import com.ideas2it.universityManagement.util.JWTUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Controller of University
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@RestController
@Slf4j
public class UniversityController {

    @Autowired
    private UniversityServiceImpl universityServiceImpl;
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    /**
     * Add University to databases
     *
     * @param university - store university object
     * @return String - return response as a String
     * @throws UniversityException - gives a response as http status and exception msg
     */
    @PostMapping("/university")
    private ResponseEntity<University> save(@Valid @RequestBody University university) throws UniversityException {
        Optional<University> universityDb
                = universityServiceImpl.save(university);

        log.info("inside the add method of University");
        if ( universityDb.isPresent() ) {
            return ResponseEntity.status(HttpStatus.CREATED).body(universityDb.get());
        } else {
            throw new UniversityException("invalid request");
        }
    }

    /**
     * Fetch the data all university data from DB
     *
     * @return universities - return all university as response
     */
    @GetMapping("/university")
    public ResponseEntity<List<University>> getAll() {
        List<University> universities = universityServiceImpl.getAll();

        log.info("inside the fetch all data");
        if ( !universities.isEmpty() ) {
            return ResponseEntity.status(HttpStatus.OK).body(universities);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(universities);
        }
    }

    /**
     * Fetch the university details from Db using id
     *
     * @param universityId - gives id to get a data
     * @return university details - give response as university details
     * @throws UniversityException - gives a response as http status and exception msg
     */
    @GetMapping("/university/{id}")
    public ResponseEntity<University> getById(@PathVariable("id") Long universityId) throws UniversityException {
        Optional<University> university = universityServiceImpl.getById(universityId);

        log.info("inside fetch a particular data by id");
        if ( university.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(university.get());
        } else {
            throw new UniversityException("There is no university under this id");
        }
    }

    /**
     * Update university using id
     *
     * @param university - gives updated data to store
     * @return String - gives response statement for the update progress
     * @throws UniversityException - gives a response as http status and exception msg
     */
    @PutMapping("/university")
    public ResponseEntity<University> update(@RequestBody University university) throws UniversityException {
        Optional<University> universityOptional = universityServiceImpl.update(university);

        log.info("inside update the field");
        if ( universityOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(universityOptional.get());
        } else {
            throw new UniversityException("We Couldn't update the data");
        }
    }

    /**
     * Delete university using id
     *
     * @param universityId - give id to delete university
     * @return String - give a response to delete the university
     * @throws UniversityException - gives a response as http status and exception msg
     */
    @DeleteMapping(value = "/university/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long universityId) throws UniversityException {
        Optional<String> temp = universityServiceImpl.delete(universityId);

        if ( temp.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(temp.get());
        } else {
            throw new UniversityException("We couldn't delete the data");
        }
    }

    /**
     * Authentication request using jwt token
     *
     * @param jwtRequest -
     * @return JwtResponse -
     * @throws Exception -
     */
    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch ( BadCredentialsException exception ) {
            throw new Exception("Invalid_credentials");
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }
}