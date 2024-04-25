package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;

import java.time.LocalDateTime;

import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ConfigurationResponseDTO {

	public ConfigurationResponseDTO(ConfigurationModel configurationCatalog) {
		this.id = configurationCatalog.getId();
	}

	private Long id;
	private String country;
	private String primaryBook;
	private String secondBook;
	private String operationalUnit;
	private String divisa;
	private String passiveAcount;
	private LocalDateTime inactivationDate;
	private Boolean enabled;
}
