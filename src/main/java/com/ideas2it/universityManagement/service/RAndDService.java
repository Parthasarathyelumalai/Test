package com.ideas2it.universityManagement.service;

import com.ideas2it.universityManagement.model.RAndD;

import java.util.List;
import java.util.Optional;


/**
 * <p> Interface of Research and development
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.011/7/2022
 */
public interface RAndDService {

    /**
     * Add RandD in Db
     *
     * @param rAndD - store rAndD in Db
     * @return - gives response as primary key
     */
    Optional<RAndD> save(RAndD rAndD);

    /**
     * Fetch all research and data
     *
     * @return list - get all research and development details from data
     *
     */
    List<RAndD> getAll();

    /**
     * Fetch research and development
     *
     * @param rAndDId - get research and development by id
     * @return rAndD -  return rAndD details
     *
     */
    Optional<RAndD> getById(Long rAndDId);

    /**
     * Delete rAndD by id
     *
     * @param rAndDId - pass id to delete R&D
     * @return String - give response statement
     */
    Optional<String> delete(Long rAndDId);

    /**
     * Update R&D
     *
     * @param rAndD - update the details in Db
     * @return String - gives response statement
     */
    Optional<RAndD> update(RAndD rAndD);

}
