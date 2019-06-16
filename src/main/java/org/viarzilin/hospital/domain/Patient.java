package org.viarzilin.hospital.domain;

import lombok.Data;
import org.viarzilin.hospital.domain.abstractClasses.AbstractUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="patient")
@Data
public class Patient extends AbstractUser {

    @NotBlank(message = "Please fill the City")
    private String city;

    @NotBlank(message = "Please fill the Street")
    private String street;

    private String building;

    @NotNull(message = "Please fill the Apartment")
    @Min(message = "Min value 1", value = 1)
    private Integer apartment;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}
