package org.viarzilin.hospital.domain;

import lombok.Data;
import org.viarzilin.hospital.domain.abstractClasses.AbstractUser;
import org.viarzilin.hospital.domain.enums.UserRoles;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_table")
@Data
public class User extends AbstractUser {

    @NotNull(message = "Please fill the Username")
    @Column(name = "username", updatable = false, unique = true)
    private String username;

    @Size(min = 8, max = 16, message = "Password must be from 8-16 characters")
    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Email
    @Column(name = "email",unique = true, nullable = false, length = 20)
    private String email;

    @Column(name="isactive")
    private boolean isActive=true;

    @NotNull
    @Column(name="department")
    private String department;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRoles role;

}
