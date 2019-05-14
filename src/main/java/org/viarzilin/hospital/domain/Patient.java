package org.viarzilin.hospital.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String lastname;
    private String firstname;
    private String surname;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "created_date", updatable = false)
    private Date createdDate;
    @Column(name = "updated_date", updatable = true)
    private Date updatedDate;
}
