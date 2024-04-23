package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConfigurationDTO {
	
	private Long id;
	private String country;
	private String primaryBook;
	private String secondBook;
	private String operationalUnit;
	private String currency;
	private String liabilityAccount;
	private LocalDateTime inactivationDate;
}
