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


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"XXPAR_CONFIGURATION_CATALOG\"" )
public class ConfigurationModel {

  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

 @NonNull
  @Column(name = "country")
  private String country;
  @NonNull
  @Column(name = "primary_book")
  private String primaryBook;
  @NonNull
  @Column(name = "second_book")
  private String secondBook;
  @NonNull
  @Column(name = "operational_unit")
  private String operationalUnit;
  @NonNull
  @Column(name = "divisa")
  private String divisa;
  @NonNull
  @Column(name = "passive_acount")
  private String passiveAcount;
  @NonNull
   @Column(name = "inactivation_date", nullable = true)
   private  Date inactivationDate;
   @NonNull
   @Column(name = "enabled",nullable = true)
   private Boolean enabled;

  @Column(name = "creation_date")
  private  Date createdDate;

  @Column(name = "created_by")
  private Long createdBy;

   @Column(name = "last_update_date")
  private  Date lastUpdateDate;

  @Column(name = "last_updated_by ")
  private Long lastupdatedby ;

  @Column(name = "last_update_login")
  private Long lastUpdateLogin ;

 


}
