package org.viarzilin.hospital.domain.abstractClasses;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AbstractEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime  updatedDate;

    @NonNull
    @Column(name="isdeleted")
    private boolean isDeleted=false;

}
