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
import java.util.Optional;
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
    public ConfigurationModel saveConfiguration(ConfigurationModel configuration) {
        Optional<ConfigurationModel> existingConfiguration = configurationRepository
                .findByCountry(configuration.getCountry());
        if (existingConfiguration.isPresent()) {
            throw new DuplicateCountryException("Country already exists");
        }
        return configurationRepository.save(configuration);
    }

    public class DuplicateCountryException extends RuntimeException {
        public DuplicateCountryException(String message) {
            super(message);
        }
    }
}
