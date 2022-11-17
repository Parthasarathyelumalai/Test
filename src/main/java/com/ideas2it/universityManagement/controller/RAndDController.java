package com.ideas2it.universityManagement.controller;

import com.ideas2it.universityManagement.exception.RAndDException;
import com.ideas2it.universityManagement.model.RAndD;
import com.ideas2it.universityManagement.service.RAndDServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * Controller of Research and Development
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@RestController
@Slf4j
public class RAndDController {

    @Autowired
    private RAndDServiceImpl rAndDServiceImpl;

    /**
     * Add Research and Development in Db
     *
     * @param rAndD - store data research and Development
     * @return String - gives response statement
     * @throws RAndDException - gives a https status and exception msg
     */
    @PostMapping("/randd")
    private ResponseEntity<RAndD> save(@Valid @RequestBody RAndD rAndD) throws RAndDException {
        Optional<RAndD> rAndDOptional = rAndDServiceImpl.save(rAndD);

        if ( rAndDOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.CREATED).body(rAndDOptional.get());
        } else {
            throw new RAndDException("invalid request");
        }
    }

    /**
     * Fetch all Research and Development in Db
     *
     * @return List - gives all R&d data as response
     */
    @GetMapping("/randd")
    public ResponseEntity<List<RAndD>> getAll() {
        List<RAndD> rAndDS = rAndDServiceImpl.getAll();

        if ( rAndDS.isEmpty() ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rAndDS);
        }
        return ResponseEntity.status(HttpStatus.OK).body(rAndDS);
    }

    /**
     * Fetch Research and Development in Db
     *
     * @param rAndDId - get research and Development data by id
     * @return rAndD - gives response as R&D data
     * @throws RAndDException - gives a https status and exception msg
     */
    @GetMapping("/randd/{id}")
    public ResponseEntity<RAndD> getById(@PathVariable("id") Long rAndDId) throws RAndDException {
        Optional<RAndD> rAndDOptional = rAndDServiceImpl.getById(rAndDId);

        log.info("inside fetch a particular data by id");
        if ( rAndDOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(rAndDOptional.get());
        } else {
            throw new RAndDException("There is no research and Development under this id");
        }
    }

    /**
     * Delete Research and Development in Db
     *
     * @param rAndDId - delete research and Development data
     * @return String - gives a response statement
     * @throws RAndDException - gives a https status and exception msg
     */
    @DeleteMapping("/randd/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long rAndDId) throws RAndDException {
        Optional<String> temp = rAndDServiceImpl.delete(rAndDId);

        if ( temp.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(temp.get());
        } else {
            throw new RAndDException("We couldn't delete the data");
        }
    }

    /**
     * update Research and Development in Db
     *
     * @param rAndD - updated R&D store in db
     * @return String - gives a response statement
     * @throws RAndDException - gives a https status and exception msg
     */
    @PutMapping("/randd")
    public ResponseEntity<RAndD> update(@RequestBody RAndD rAndD) throws RAndDException {
        Optional<RAndD> rAndDOptional = rAndDServiceImpl.update(rAndD);

        if ( rAndDOptional.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(rAndDOptional.get());
        } else {
            throw new RAndDException("We Couldn't update the data");
        }
    }
}