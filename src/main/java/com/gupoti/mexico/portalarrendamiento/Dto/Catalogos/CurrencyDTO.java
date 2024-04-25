package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyDTO {
    
    private Long Id;

    private String currencyCode;

    private String currency;

    private Boolean enabled;
}
