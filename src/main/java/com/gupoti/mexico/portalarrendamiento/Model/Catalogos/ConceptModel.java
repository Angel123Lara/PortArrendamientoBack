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
    private Long id;
    @NonNull
    @Column(name="portal_concept")
    private String portalConcept;
    @NonNull
    @Column(name="ebs_concept")
    private String ebsConcept;
    @Column(name="inactivation_date")
    private Date inactivationDate;
    @NonNull
    @Column(name="enabled")
    private Boolean enabled;
    @Column(name="creation_date")
    private Date creationDate;
    @Column(name="created_by")
    private Long createdBy;
    @Column(name="last_update_date")
    private Date lastUpdateDate;
    @Column(name="last_updated_by")
    private Long lastUpdatedBy;
    @Column(name="last_update_login")
    private Long lastUpdateLogin;
    

}