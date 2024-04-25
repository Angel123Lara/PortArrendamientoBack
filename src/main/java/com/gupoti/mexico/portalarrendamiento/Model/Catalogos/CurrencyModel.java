package com.gupoti.mexico.portalarrendamiento.Model.Catalogos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "\"XXPAR_AGR_CURRENCIES_CATALOG_T\"")
public class CurrencyModel {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; 
    @NonNull
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @NonNull
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "creation_date")
    private Date creationDate = new Date();
    @Column(name = "created_by")
    private Long createdBy ;
    @Column(name = "last_update_date")
    private Date lastUpdateDate;
    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;
    @Column(name = "last_update_login")
    private Long lastUpdateLogin;
    @NonNull
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

}
