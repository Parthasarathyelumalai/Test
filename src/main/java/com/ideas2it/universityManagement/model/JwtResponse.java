package com.ideas2it.universityManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Parthasarathy elumalai
 * @version 1.0 9-11-2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String jwtToken;
}
