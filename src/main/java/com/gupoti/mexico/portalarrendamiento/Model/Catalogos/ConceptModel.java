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
    private String portal_concept;
    @Column(name="EBS_CONCEPT")
    private String EBS_concept;
    @Column(name="INACTIVATION_DATE")
    private Date inactivation_date;
    @Column(name="CREATION_DATE")
    private Date creation_date;
    @Column(name="CREATED_BY")
    private Long created_by;
    @Column(name="LAST_UPDATE_DATE")
    private Date last_update_date;
    @Column(name="LAST_UPDATE_BY")
    private Long last_updated_by;
    @Column(name="LAST_UPDATE_LOGIN")
    private Long last_update_login;
    @Column(name="ENABLED")
    private Boolean enabled;

}