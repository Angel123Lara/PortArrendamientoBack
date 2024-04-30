package com.gupoti.mexico.portalarrendamiento.Service.Catalogos;

import java.util.List;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;


public interface ConfigurationService {
    List<ConfigurationResponseDTO> getAllConfigurations();
    ConfigurationResponseDTO create(ConfigurationRequestDTO request);
    ConfigurationResponseDTO get(String country);
    ConfigurationResponseDTO update(String country, ConfigurationRequestDTO request);
   
}
