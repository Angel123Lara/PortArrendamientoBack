package com.gupoti.mexico.portalarrendamiento.Service.Catalogos;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;

public interface ConfigurationService {
    ConfigurationResponseDTO create(ConfigurationRequestDTO request);
    ConfigurationResponseDTO get(String country);
    ConfigurationResponseDTO update(String country, ConfigurationRequestDTO request);
}
