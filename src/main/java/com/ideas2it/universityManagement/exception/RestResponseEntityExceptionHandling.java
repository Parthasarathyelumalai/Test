package com.ideas2it.universityManagement.exception;

import com.ideas2it.universityManagement.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <p>RestResponse Entity Exception Handling
 * </p>
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandling extends ResponseEntityExceptionHandler {

    /**
     * Response entity for handling University not Found Exception
     *
     * @param universityException - there is no university exception
     * @param webRequest                  - https status
     * @return
     */
    @ExceptionHandler(UniversityException.class)
    public ResponseEntity<ErrorMessage> universityNotFoundException(UniversityException universityException, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, universityException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    /**
     * Response entity for handling College not Found Exception
     *
     * @param collegeException - there is no College exception
     * @param webRequest               - https status
     * @return
     */
    @ExceptionHandler(CollegeException.class)
    public ResponseEntity<ErrorMessage> collegeNotFoundException(CollegeException collegeException, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, collegeException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }


    /**
     * Response entity for handling research and development  not Found Exception
     *
     * @param rAndDException - there is no Research and development exception
     * @param webRequest             - https status
     * @return
     */
    @ExceptionHandler(RAndDException.class)
    public ResponseEntity<ErrorMessage> rAndDNotFoundException(RAndDException rAndDException, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, rAndDException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
