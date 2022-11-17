package com.ideas2it.universityManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Pojo Address
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid Plot number")
    private String plotNo;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @Pattern(regexp = "^[a-zA-z]{1}[a-zA-Z\\s]*$", message = "Invalid Street Name")
    private String Street;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @Pattern(regexp = "^[a-zA-z]{1}[a-zA-Z\\s]*$", message = "Invalid District Name")
    private String District;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @Pattern(regexp = "^[a-zA-z]{1}[a-zA-Z\\s]*$", message = "Invalid State Name")
    private String State;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{5}", message = "Invalid PinCode")
    private String pinCode;
}
