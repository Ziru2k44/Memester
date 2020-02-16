package com.primlook.memester.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bernardo on 1/20/2020
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @Version
    @Column(nullable = false)
    protected Long version;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    protected Timestamp createdDate;

    @Column(nullable = false, updatable = false)
    @CreatedBy
    protected String createdBy;

    @UpdateTimestamp
    @Column(nullable = false)
    protected Timestamp lastModifiedDate;

    @LastModifiedBy
    protected String modifiedBy;
}
