package com.example.demo.audit;

import com.example.demo.config.CustomRevisionListener;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entidad que representa el metadato de revisión de Envers.
 *
 * <p>Envers usa esta entidad para registrar un número de revisión y timestamp por cambio
 * (insert/update/delete) en entidades auditadas.</p>
 */
@Entity
@Table(name = "Revision_Info")
@RevisionEntity(CustomRevisionListener.class)
@Data
public class Revision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(name = "revision_seq",sequenceName = "rbac.seq_revision_id")
    @RevisionNumber
    private int id;

    /**
     * Timestamp de la revisión (cuando se creó la revisión).
     */
    @Column(name = "Revision_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;
}