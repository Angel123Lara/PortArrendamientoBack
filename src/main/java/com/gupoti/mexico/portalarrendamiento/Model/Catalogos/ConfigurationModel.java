package com.gupoti.mexico.portalarrendamiento.Model.Catalogos;
import java.time.Instant;
import java.time.LocalDateTime;
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


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"XXPAR_CONFIGURATION_CATALOG\"" )
public class ConfigurationModel {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "country",unique = true)
  private String country;

  @Column(name = "primary_book")
  private String primaryBook;

  @Column(name = "second_book")
  private String secondBook;

  @Column(name = "operational_unit")
  private String operationalUnit;

  @Column(name = "divisa")
  private String divisa;

  @Column(name = "passive_acount")
  private String passiveAcount;

   @Column(name = "inactivation_date", nullable = true)
   private Instant inactivationDate;

   @Column(name = "enabled")
   private Boolean enabled;

  @Column(name = "created_date")
  private Date createdDate;

  @Column(name = "created_by")
  private Long createdBy;

   @Column(name = "last_update_date")
  private Date lastUpdateDate;

  @Column(name = "last_updated_by ")
  private Long lastupdatedby ;

  @Column(name = "last_update_login")
  private Long lastUpdateLogin ;

 


}
