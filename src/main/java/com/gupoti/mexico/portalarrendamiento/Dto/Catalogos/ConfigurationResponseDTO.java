package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConfigurationResponseDTO {

	
	private Long id;
	private String country;
	private String primaryBook;
	private String secondBook;
	private String operationalUnit;
	private String divisa;
	private String passiveAcount;
	private Boolean enabled;
}
