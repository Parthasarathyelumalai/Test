package com.ideas2it.universityManagement.controller;

import com.ideas2it.universityManagement.exception.CollegeException;
import com.ideas2it.universityManagement.model.College;
import com.ideas2it.universityManagement.service.CollegeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Controller of College
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@RestController
@Slf4j
public class CollegeController {

    @Autowired
    private CollegeServiceImpl collegeServiceImpl;

    /**
     * Add College in Databases
     *
     * @param college - Add university
     * @return String - gives a response statement
     * @throws CollegeException - gives response as http response and exception message
     */
    @PostMapping("/college")
    private ResponseEntity<College> save(@RequestBody College college) throws CollegeException {
        Optional<College> collegeOptional = collegeServiceImpl.save(college);

        if ( collegeOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(collegeOptional.get());
        } else {
            throw new CollegeException("We couldn't save the data");
        }
    }

    /**
     * Fetch all university details from db
     *
     * @return universities - gives all data as response
     */
    @GetMapping("/college")
    private ResponseEntity<List<College>> getAll() {
        List<College> colleges = collegeServiceImpl.getAll();

        if ( !colleges.isEmpty() ) {
            return ResponseEntity.status(HttpStatus.OK).body(colleges);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(colleges);
        }
    }

    /**
     * Fetch university details from Db
     *
     * @param collegeId - get data using id
     * @return college - gives college details as response
     * @throws CollegeException - gives response as http response and exception message
     */
    @GetMapping("/college/{id}")
    private ResponseEntity<College> getById(@PathVariable("id") Long collegeId) throws CollegeException {
        Optional<College> collegeOptional = collegeServiceImpl.getById(collegeId);

        if ( collegeOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(collegeOptional.get());
        } else {
            throw new CollegeException("there is no college under this id");
        }
    }

    /**
     * update college in Db
     *
     * @param college - updated the data in Db
     * @return String - gives response statement
     * @throws CollegeException - gives response as http response and exception message
     */
    @PutMapping("/college")
    public ResponseEntity<College> update(@Valid @RequestBody College college) throws CollegeException {
        Optional<College> collegeOptional = collegeServiceImpl.update(college);

        if ( collegeOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(collegeOptional.get());
        } else {
            throw new CollegeException("We couldn't update the details");
        }
    }

    /**
     * Delete College based on id
     *
     * @param collegeId - give id to delete college in db
     * @return String - gives response statement
     * @throws CollegeException - gives response as http response and exception message
     */
    @DeleteMapping("/college/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long collegeId) throws CollegeException {
        Optional<String> temp = collegeServiceImpl.delete(collegeId);

        if ( temp.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(temp.get());
        } else {
            throw new CollegeException("We Couldn't delete data");
        }
    }
}
