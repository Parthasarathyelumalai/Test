package com.ideas2it.universityManagement.service;

import com.ideas2it.universityManagement.model.RAndD;
import com.ideas2it.universityManagement.repository.RAndDRepository;
import com.ideas2it.universityManagement.util.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * <p> Implementation of Research and development
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.011/7/2022
 */
@Service
public class RAndDServiceImpl implements RAndDService {

    @Autowired
    RAndDRepository rAndDRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<RAndD> save(RAndD rAndD) {
        Optional<RAndD> rAndDOptional= Optional.of(rAndDRepository.save(rAndD));

        if (rAndDOptional.isPresent()) {
            return rAndDOptional;
        } else {
            return Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RAndD> getAll() {
        return rAndDRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<RAndD> getById(Long rAndDId) {
        Optional<RAndD> rAndD = rAndDRepository.findById(rAndDId);

        if ( rAndD.isPresent() ) {
            return rAndD;
           // throw new RAndDException("there is no research and development under this id");
        } else {
            return Optional.empty();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> delete(Long rAndDId) {
        try {
            rAndDRepository.deleteById(rAndDId);
            return Optional.of("Deleted Successfully");
        } catch ( DataAccessException exception ) {
            //throw new RAndDException("there is no research and development under this id to delete" + exception);
            return Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<RAndD> update(RAndD rAndD) {
        if (validateRAndD(rAndD)) {
            return Optional.of(rAndDRepository.save(rAndD));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param rAndD - research and development to check is valid or not
     * @return boolean - true or false
     */
    private boolean validateRAndD(RAndD rAndD) {
        return CommonUtility.isValidName(rAndD.getName());
    }
}
