package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConfigurationResponseDTO {

	public ConfigurationResponseDTO(ConfigurationModel configurationCatalog) {
		this.id = configurationCatalog.getId();
		
	}
    @JsonIgnore
	private Long id;
	private String country;
	private String primaryBook;
	private String secondBook;
	private String operationalUnit;
	private String divisa;
	private String passiveAcount;
	
}
