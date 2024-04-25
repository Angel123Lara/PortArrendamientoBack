package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/catalogs/configurations")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping
    public ResponseEntity<List<ConfigurationResponseDTO>> getAllConfigurations() {
        List<ConfigurationResponseDTO> configurations = configurationService.getAllConfigurations();
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigurationResponseDTO> getConfigurationById(@PathVariable Long id) {
        ConfigurationResponseDTO configuration = configurationService.getConfigurationById(id);
        return new ResponseEntity<>(configuration, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigurationResponseDTO> createConfiguration(
          @Valid  @RequestBody ConfigurationRequestDTO configurationRequestDTO) {
        ConfigurationResponseDTO configuration = configurationService.createConfiguration(configurationRequestDTO);
        return new ResponseEntity<>(configuration, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfigurationResponseDTO> updateConfiguration(@PathVariable Long id,
            @RequestBody ConfigurationRequestDTO configurationRequestDTO) {
        ConfigurationResponseDTO configuration = configurationService.updateConfiguration(id, configurationRequestDTO);
        return new ResponseEntity<>(configuration, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long id) {
        configurationService.deleteConfiguration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   

}
