package com.ideas2it.universityManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Pojo of College
 *
 * @author Parthasarathy elumalai
 * @version 1.0 11/7/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Role description field length should not exceed 255")
    @Pattern(regexp = "^[a-zA-z]{1}[a-zA-Z\\s]*$", message = "Invalid Name")
    private String name;

    private int college_rank;

    private int staffStrength;

    private int studentStrength;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "college_Id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "college_Id")
    private List<Contact> contacts;
}
