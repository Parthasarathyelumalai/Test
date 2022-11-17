package com.ideas2it.universityManagement.service;

import com.ideas2it.universityManagement.model.College;

import java.util.List;
import java.util.Optional;

/**
 * <p> Interface of College service
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.011/7/2022
 */
public interface CollegeService {

    /**
     * Add college d ata to db
     *
     * @param college - store college data
     * @return id - primary id
     */
    Optional<College> save(College college);

    /**
     * Fetch all data from college table
     *
     * @return list - return all data in college table
     */
    List<College> getAll();

    /**
     * Fetch college by id
     *
     * @param collegeId - get a college data from db using id
     * @return college - return college details
     */
    Optional<College> getById(Long collegeId);

    /**
     * Delete college data in Db
     *
     * @param collegeId - delete data from the db using id
     * @return String - gives response statement
     */
    Optional<String> delete(Long collegeId);

    /**
     * Updated College details in db
     *
     * @param college - send a updated college details to Db
     * @return String - gives a response statement
     */
    Optional<College> update(College college);

}
