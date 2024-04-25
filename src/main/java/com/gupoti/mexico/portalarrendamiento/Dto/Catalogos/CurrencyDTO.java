package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDTO {
    
    private Long Id;

    private String currencyCode;

    private String currency;

    private Boolean enabled;
}
