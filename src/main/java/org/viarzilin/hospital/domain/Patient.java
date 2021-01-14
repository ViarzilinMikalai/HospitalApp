package org.viarzilin.hospital.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.viarzilin.hospital.domain.abstractClasses.AbstractEntity;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="patient")
@Data
public class Patient extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Please fill the Lastname")
    private String lastname;

    @NotBlank(message = "Please fill the Firstname")
    private String firstname;

    @NotBlank(message = "Please fill the Surname")
    private String surname;

    @NotBlank(message = "Please fill the City")
    private String city;

    @NotBlank(message = "Please fill the Street")
    private String street;

    private String building;

    @NotNull(message = "Please fill the Apartment")
    @Min(message = "Min value 1", value = 1)
    private Integer apartment;

    @Column(name = "birth_date")
    @NotNull(message = "Please fill the date of Birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

}
