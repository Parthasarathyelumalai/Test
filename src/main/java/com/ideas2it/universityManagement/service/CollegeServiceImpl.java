package com.ideas2it.universityManagement.service;

import com.ideas2it.universityManagement.model.College;
import com.ideas2it.universityManagement.repository.CollegeRepository;
import com.ideas2it.universityManagement.util.CommonUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * <p> Implementation of College service
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.011/7/2022
 */
@Service
@Slf4j
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    CollegeRepository collegeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<College> save(College college) {
        Optional<College> collegeOptional = Optional.of(collegeRepository.save(college));

        if ( collegeOptional.isPresent() ) {
            return collegeOptional;
        } else {
            return Optional.empty();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<College> getAll() {
        List<College> colleges = collegeRepository.findAll();
        return colleges;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<College> getById(Long collegeId) {
        Optional<College> college = collegeRepository.findById(collegeId);

        if ( college.isPresent() ) {
            return college;
        }else {
            return Optional.empty();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> delete(Long collegeId) {
        try {
            collegeRepository.deleteById(collegeId);
            return Optional.of("Deleted Successfully");
        } catch ( DataAccessException exception ) {
            return Optional.empty();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<College> update(College college) {
        if ( validateCollege(college) ) {
            log.info("valid info");
            return Optional.of(collegeRepository.save(college));
        } else {
            return Optional.empty();
        }
    }

    /**
     * validate the college
     * @param college before update
     * @return boolean - true/false
     */
    private boolean validateCollege(College college) {
        return CommonUtility.isValidName(college.getName());
    }
}
