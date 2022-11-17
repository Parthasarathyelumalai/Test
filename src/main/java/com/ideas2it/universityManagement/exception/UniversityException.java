package com.ideas2it.universityManagement.exception;

import org.springframework.dao.DataAccessException;

/**
 * <p> University Not Found Exception
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
public class UniversityException extends Exception {

    public UniversityException(String message) {
        super(message);
    }

    public UniversityException(String message, DataAccessException exception) {
        super(message + exception.getMessage());
    }
}
