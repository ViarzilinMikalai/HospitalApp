package org.viarzilin.hospital.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.viarzilin.hospital.domain.abstractClasses.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "departments")
@Data
public class Department extends AbstractEntity{

    @NotBlank(message = "Please fill the department")
    @Column(name = "name", unique = true)
    private String name;
}
