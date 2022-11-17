package com.ideas2it.universityManagement.service;

import com.ideas2it.universityManagement.exception.UniversityException;
import com.ideas2it.universityManagement.model.University;

import java.util.List;
import java.util.Optional;


/**
 * <p> Interface of University service
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.011/7/2022
 */
public interface UniversityService {

    /**
     * Add university details in Db
     *
     * @param university - store university data in dB
     * @return id - return primary key response
     */
    Optional<University> save(University university);

    /**
     * Fetch all university from Db
     *
     * @return List - gives response as all university details.
     */
    List<University> getAll();

    /**
     * Fetch university data from db
     *
     * @param university_id - fetch a data from db using id
     * @return university details - return all details of university
     */
    Optional<University> getById(Long university_id);

    /**
     * Delete university by id
     *
     * @param university_id - id to delete data
     * @return String - gives a response statement
     * @throws UniversityException - throws exception to controller to handle
     */
    Optional<String> delete(Long university_id);

    /**
     * update university
     *
     * @param university updated data to set in existed data
     * @return String - gives response as statement
     * @throws UniversityException - throws exception to controller to handle
     */
    Optional<University> update(University university);


}
