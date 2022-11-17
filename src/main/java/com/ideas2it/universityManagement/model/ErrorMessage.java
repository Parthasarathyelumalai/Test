package com.ideas2it.universityManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Error class
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus httpStatus;
    private String message;
}
