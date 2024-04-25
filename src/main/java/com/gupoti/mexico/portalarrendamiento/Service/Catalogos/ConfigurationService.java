package com.gupoti.mexico.portalarrendamiento.Service.Catalogos;
import java.util.List;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;

public interface ConfigurationService {
    List<ConfigurationResponseDTO> getAllConfigurations();

    ConfigurationResponseDTO getConfigurationById(Long id);

    ConfigurationResponseDTO createConfiguration(ConfigurationRequestDTO configurationRequestDTO);

    ConfigurationResponseDTO updateConfiguration(Long id, ConfigurationRequestDTO configurationRequestDTO);

    void deleteConfiguration(Long id);

    ConfigurationResponseDTO createConfigurationCatalog(ConfigurationRequestDTO request);
}
