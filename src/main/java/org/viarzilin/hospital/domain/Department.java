package org.viarzilin.hospital.domain;

import lombok.Data;
import org.viarzilin.hospital.domain.abstractClasses.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "departments")
@Data
public class Department extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Please fill the department")
    @Column(name = "name")
    private String name;
}
