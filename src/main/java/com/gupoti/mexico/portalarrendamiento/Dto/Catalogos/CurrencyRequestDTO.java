package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CurrencyRequestDTO {
    
    @NotNull(message = "this field isn't null")
    @NotEmpty(message = "this field isn't empty")
    @NotBlank(message = "this field isn't blank")
    @Size(min = 1, max = 3, message = "the max length is 3" )
    private String currencyCode;

    @NotNull(message = "this field isn't null")
    @NotEmpty(message = "this field isn't empty")
    @NotBlank(message = "this field isn't blank")
    @Size(min = 1, max= 50 , message = "the max length is 50")
    private String divisa;
    
}
