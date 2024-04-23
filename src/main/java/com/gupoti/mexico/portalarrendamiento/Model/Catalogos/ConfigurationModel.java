package com.gupoti.mexico.portalarrendamiento.Model;
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
public class C_ConfigurationModel {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "primary_book", nullable = false)
  private String primaryBook;

  @Column(name = "second_book", nullable = false)
  private String secondBook;

  @Column(name = "operational_unit", nullable = false)
  private String operationalUnit;

  @Column(name = "currency", nullable = false)
  private String currency;

  @Column(name = "liability_account", nullable = false)
  private String liabilityAccount;

  @Column(name = "inactivation_date")
  private LocalDateTime inactivationDate;
}
