package com.gupoti.mexico.portalarrendamiento.Model.Catalogos;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "XXPAR_AGR_CONCEPTS_CATALOG_T")
public class ConceptModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="portal_concept")
    private String portal_concept;
    @Column(name="EBS_concept")
    private String EBS_concept;
    @Column(name="inactivation_date")
    private Date inactivation_date;
    @Column(name="creation_date")
    private Date creation_date;
    @Column(name="created_by")
    private Date created_by;
    @Column(name="last_update_date")
    private Date last_update_date;
    @Column(name="last_update_by")
    private Long last_updated_by;
    @Column(name="last_update_login")
    private Long last_update_login;
    @Column(name="enabled")
    private Boolean enabled;

}