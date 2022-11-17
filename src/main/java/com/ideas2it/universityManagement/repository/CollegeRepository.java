package com.ideas2it.universityManagement.repository;

import com.ideas2it.universityManagement.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface of Repository of College
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

}
