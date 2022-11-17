package com.ideas2it.universityManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Pojo of University
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Role description field length should not exceed 255")
    @Pattern(regexp = "^[a-zA-z]{1}[a-zA-Z\\s]*$", message = "Invalid Name")
    private String name;

    private String password;

    private String role;

    private int University_rank;

    private LocalDate foundedDate;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "university_Id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "university_Id")
    private List<Contact> contacts;
}
