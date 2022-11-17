package com.ideas2it.universityManagement.service;

import com.ideas2it.universityManagement.model.University;
import com.ideas2it.universityManagement.repository.UniversityRepository;
import com.ideas2it.universityManagement.util.CommonUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p> Implementation of University service
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Service
@Slf4j
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<University> save(University university) {
        Optional<University> universityOptional = Optional.of(universityRepository.save(university));

        if (universityOptional.isPresent()) {
            return universityOptional;
        } else {
            return Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<University> getAll() {
        List<University> universities = universityRepository.findAll();
        return universities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<University> getById(Long university_id) {
        Optional<University> university = universityRepository.findById(university_id);

        if (university.isPresent()) {
            return university;
        } else {
            return Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> delete(Long university_id) {
        try {
            universityRepository.deleteById(university_id);
            return Optional.of("Deleted Successfully");
        } catch ( DataAccessException exception ) {
            return Optional.empty();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<University> update(University university) {
        if (validateUniversity(university)) {
            return Optional.of(universityRepository.save(university));
        } else {
            return Optional.empty();
        }
    }
/*    private String findUniversityName() {
        universityRepository
    }*/
    /**
     * validate the university
     * @param university pass university to validate
     * @return boolean true or false
     */
    private boolean validateUniversity(University university) {
        return CommonUtility.isValidName(university.getName());
    }

}
