package com.gupoti.mexico.portalarrendamiento.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class C_ConfigurationDTO {
	
	    private Long id;
	    private String country;
	    private String primaryBook;
	    private String secondBook;
	    private String operationalUnit;
	    private String currency;
	    private String liabilityAccount;
	    private LocalDateTime inactivationDate;
}
