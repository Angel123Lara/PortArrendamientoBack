package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyDTO;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationService;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/catalogs/configurations")
public class ConfigurationController {
private final ConfigurationService service;
   @Autowired
    private ConfigurationService configurationService;
    public ConfigurationController(ConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConfigurationResponseDTO> create(@Valid @RequestBody ConfigurationRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{country}")
    public ResponseEntity<ConfigurationResponseDTO> get(@PathVariable String country) {
        return ResponseEntity.ok(service.get(country));
    }


    @PutMapping("/{country}")
    public ResponseEntity<ConfigurationResponseDTO> update(@Valid @PathVariable String country, @RequestBody ConfigurationRequestDTO request) {
        return ResponseEntity.ok(service.update(country, request));
    }
   @GetMapping ("/all")
    public ResponseEntity<List<ConfigurationResponseDTO>> getAllConfigurations() {
        List<ConfigurationResponseDTO> configurations = configurationService.getAllConfigurations();
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }
    
    @PostMapping("enabled/{id}")
    public ResponseEntity<ConfigurationResponseDTO> enabledById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.enabledById(id));
    }
}