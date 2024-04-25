package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.ConfigurationRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationService;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

  
        public ConfigurationServiceImpl(ConfigurationRepository configurationRepository) {
            this.configurationRepository = configurationRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ConfigurationResponseDTO> getAllConfigurations() {
        return configurationRepository.findAll().stream()
                .map(configurationModel -> modelMapper.map(configurationModel, ConfigurationResponseDTO.class))
                     .collect(Collectors.toList());
    }

    @Override
    public ConfigurationResponseDTO getConfigurationById(Long id) {
        ConfigurationModel configurationModel = configurationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Configuration not found"));
                    return modelMapper.map(configurationModel, ConfigurationResponseDTO.class);
    }

    @Override
    public ConfigurationResponseDTO createConfiguration(ConfigurationRequestDTO configurationRequestDTO) {
        ConfigurationModel configurationModel = modelMapper.map(configurationRequestDTO, ConfigurationModel.class);
            ConfigurationModel savedConfigurationModel = configurationRepository.save(configurationModel);
                return modelMapper.map(savedConfigurationModel, ConfigurationResponseDTO.class);
    }

    @Override
    public ConfigurationResponseDTO updateConfiguration(Long id, ConfigurationRequestDTO configurationRequestDTO) {
        ConfigurationModel configurationModel = configurationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Configuration not found"));
                    configurationModel.setCountry(configurationRequestDTO.getCountry());
                    configurationModel.setPrimaryBook(configurationRequestDTO.getPrimaryBook());
                    configurationModel.setSecondBook(configurationRequestDTO.getSecondBook());
                    configurationModel.setOperationalUnit(configurationRequestDTO.getOperationalUnit());
                    configurationModel.setDivisa(configurationRequestDTO.getDivisa());
                    configurationModel.setPassiveAcount(configurationRequestDTO.getPassiveAcount());

        ConfigurationModel updatedConfiguration = configurationRepository.save(configurationModel);
            return modelMapper.map(updatedConfiguration, ConfigurationResponseDTO.class);
    }

    @Override
    public void deleteConfiguration(Long id) {
        ConfigurationModel configurationModel = configurationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Configuration not found"));
                      configurationRepository.delete(configurationModel);
    }

    @Override

    public ConfigurationResponseDTO createConfigurationCatalog(ConfigurationRequestDTO request) {
        ConfigurationModel configurationCatalog = new ConfigurationModel();
        configurationCatalog.setCountry(request.getCountry().toUpperCase());
        configurationCatalog.setPrimaryBook(request.getPrimaryBook().toUpperCase());
        configurationCatalog.setSecondBook(request.getSecondBook().toUpperCase());
        configurationCatalog.setOperationalUnit(request.getOperationalUnit().toUpperCase());
        configurationCatalog.setDivisa(request.getDivisa().toUpperCase());
        configurationCatalog.setPassiveAcount(request.getPassiveAcount().toUpperCase());

        // Check if a configuration with the same country already exists
        if (configurationRepository.findByCountry(request.getCountry().toUpperCase()).isPresent()) {
            throw new DuplicateCountryException("Country must be unique");
        }
        configurationRepository.save(configurationCatalog);

        return new ConfigurationResponseDTO(configurationCatalog);
    }

}
