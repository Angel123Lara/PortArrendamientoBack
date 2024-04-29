package com.gupoti.mexico.portalarrendamiento.Model.Catalogos;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"XXPAR_CONCEPTS_CATALOG\"" )
public class ConceptModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name="PORTAL_CONCEPT")
    private String portalConcept;
    @Column(name="EBS_CONCEPT")
    private String ebsConcept;
    @Column(name="INACTIVATION_DATE")
    private Date inactivationDate;
    @Column(name="CREATION_DATE")
    private Date creationDate;
    @Column(name="CREATED_BY")
    private Long createdBy;
    @Column(name="LAST_UPDATE_DATE")
    private Date lastUpdateDate;
    @Column(name="LAST_UPDATE_BY")
    private Long lastUpdatedBy;
    @Column(name="LAST_UPDATE_LOGIN")
    private Long lastUpdateLogin;
    @Column(name="ENABLED")
    private Boolean enabled;

}