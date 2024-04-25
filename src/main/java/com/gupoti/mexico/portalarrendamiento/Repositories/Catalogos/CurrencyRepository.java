package com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.CurrencyModel;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyModel, Long> {
 
    CurrencyModel findFirstByCurrencyCode(String currencyCode);

    CurrencyModel findFirstByCurrency(String Currency);
}
