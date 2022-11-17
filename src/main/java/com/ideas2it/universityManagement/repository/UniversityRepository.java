package com.ideas2it.universityManagement.repository;

import com.ideas2it.universityManagement.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface of University Repository
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
