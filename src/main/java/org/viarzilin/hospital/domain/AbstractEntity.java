package org.viarzilin.hospital.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;
    @Column(name = "updated_date", updatable = true)
    private LocalDateTime  updatedDate;
}
