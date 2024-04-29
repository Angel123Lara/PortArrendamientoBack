package com.gupoti.mexico.portalarrendamiento.Service.Catalogos;
import java.util.List;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;

public interface ConfigurationService {
    List<ConfigurationResponseDTO> getAllConfigurations();

    ConfigurationResponseDTO getConfigurationById(Long id);

    ConfigurationResponseDTO createConfiguration(ConfigurationRequestDTO configurationRequestDTO);
    
    ConfigurationModel saveConfiguration(ConfigurationModel configuration);
}
