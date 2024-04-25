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


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"XXPAR_AGR_CONFIGURATION_CATALOG_T\"" )
public class ConfigurationModel {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "primary_book", nullable = false)
  private String primaryBook;

  @Column(name = "second_book", nullable = false)
  private String secondBook;

  @Column(name = "operational_unit", nullable = false)
  private String operationalUnit;

  @Column(name = "divisa", nullable = false)
  private String divisa;

  @Column(name = "passive_acount", nullable = false)
  private String passiveAcount;

   @Column(nullable = true)
   private Instant inactivationDate;

  @Column(name = "created_date", nullable = false)
  private LocalDateTime createdDate;

  @Column(name = "created_by", nullable = false)
  private String createdBy;

   @Column(name = "last_update_date")
  private LocalDateTime lastUpdateDate;

  @Column(name = "last_updated_by ")
  private String lastupdatedby ;

  @Column(name = "last_update_login")
  private String lastUpdateLogin ;

  @Column(name = "enabled")
  private Boolean enabled;


}
