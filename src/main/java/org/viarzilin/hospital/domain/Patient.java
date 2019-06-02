package org.viarzilin.hospital.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="patient")
@Data
public class Patient extends AbstractEntity{


    @NotBlank(message = "Please fill the Lastname")
    @Length(max = 50, message = "Tag too long (more than 50b)")
    private String lastname;
    @NotBlank(message = "Please fill the Firstname")
    @Length(max = 50, message = "Tag too long (more than 50b)")
    private String firstname;
    @NotBlank(message = "Please fill the Surname")
    @Length(max = 50, message = "Tag too long (more than 50b)")
    private String surname;
//    @NotBlank(message = "Please fill the City")
//    private String city;
//    @NotBlank(message = "Please fill the Street")
//    private String street;
//    @NotBlank(message = "Please fill the Building")
//    private String building;
//    @NotBlank(message = "Please fill the Apartment")
//    private int apartment;

    @Column(name = "birth_date")
    private LocalDate birthDate;


}
