package com.gupoti.mexico.portalarrendamiento.ServiceImpl;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.ConfigurationRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationService;

import java.util.stream.Collectors;


@Service
public class ConfigurationServiceImpl implements ConfigurationService {

       private final ConfigurationRepository repository;
    private final ModelMapper modelMapper;

    public ConfigurationServiceImpl(ConfigurationRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
public ConfigurationResponseDTO create(ConfigurationRequestDTO requestDTO) {
    ConfigurationModel existCountry = repository.findByCountry(requestDTO.getCountry());
    if (existCountry != null) {
        throw new DataIntegrityViolationException("El valor " + requestDTO.getCountry() + " ya existe y el campo solo permite valores únicos.");
    }
    ConfigurationModel model = modelMapper.map(requestDTO, ConfigurationModel.class);
    ConfigurationModel savedModel = repository.save(model);
    model.setCreatedDate(new Date());
    return modelMapper.map(savedModel, ConfigurationResponseDTO.class);
}


    @Override
    public ConfigurationResponseDTO get(String country) {
        ConfigurationModel model = repository.findByCountry(country);
        return modelMapper.map(model, ConfigurationResponseDTO.class);
    }

    @Override
    public ConfigurationResponseDTO update(String country, ConfigurationRequestDTO requestDTO) {
        ConfigurationModel existCountry = repository.findByCountry(requestDTO.getCountry());
        if (existCountry != null && !existCountry.getCountry().equals(country)) {
            throw new DataIntegrityViolationException("El valor de esta actualizacion " + requestDTO.getCountry() + " ya existe y el campo solo permite valores únicos.");
        }
        ConfigurationModel model = repository.findByCountry(country);
        model.setPrimaryBook(requestDTO.getPrimaryBook());
        model.setSecondBook(requestDTO.getSecondBook());
        model.setOperationalUnit(requestDTO.getOperationalUnit());
        model.setDivisa(requestDTO.getDivisa());
        model.setPassiveAcount(requestDTO.getPassiveAcount());
        model.setEnabled(requestDTO.getEnabled());
        model.setLastUpdateDate(new Date());
        ConfigurationModel savedModel = repository.save(model);
        return modelMapper.map(savedModel, ConfigurationResponseDTO.class);

    }
    @Override
    public List<ConfigurationResponseDTO> getAllConfigurations() {
        return repository.findAll().stream()
                .map(configurationModel -> modelMapper.map(configurationModel, ConfigurationResponseDTO.class))
                .collect(Collectors.toList());
    }

 
   
}
