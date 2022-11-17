package com.ideas2it.universityManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Contact Pojo
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^[6-9]{1}+[0-9]{9}")
    private String phoneNumber;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @NotBlank(message = "LanLine Number is mandatory")
    @Pattern(regexp = "^[04]{2}+[0-9]{8}")
    private String LandlineNumber;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @NotBlank(message = "Fax number is mandatory")
    @Pattern(regexp = "^[18]{2}+[0-9]{8}")
    private String faxNumber;

    @Size(max = 255, message = "Role description field length should not exceed 255")
    @NotBlank(message = "Email Id is mandatory")
    @Email
    private String emailId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
