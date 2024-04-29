package com.gupoti.mexico.portalarrendamiento.Model.Catalogos;
import java.time.Instant;
import java.time.LocalDateTime;
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
   private Instant inactivationDate;
   @NonNull
   @Column(name = "enabled")
   private Boolean enabled;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @Column(name = "created_by")
  private String createdBy;

   @Column(name = "last_update_date")
  private LocalDateTime lastUpdateDate;

  @Column(name = "last_updated_by ")
  private String lastupdatedby ;

  @Column(name = "last_update_login")
  private String lastUpdateLogin ;

 


}
