package org.viarzilin.hospital.domain.abstractClasses;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Data
public abstract class AbstractUser extends AbstractEntity {

    @NotBlank(message = "Please fill the Lastname")
    @Length(max = 50, message = "Lastname too long (more than 50b)")
    private String lastname;

    @NotBlank(message = "Please fill the Firstname")
    @Length(max = 50, message = "Firstname too long (more than 50b)")
    private String firstname;

    @NotBlank(message = "Please fill the Surname")
    @Length(max = 50, message = "Surname too long (more than 50b)")
    private String surname;

}
