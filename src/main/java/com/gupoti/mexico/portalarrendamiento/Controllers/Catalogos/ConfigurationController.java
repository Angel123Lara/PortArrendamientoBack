package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/catalogs/configurations")
public class ConfigurationController {
private final ConfigurationService service;

    public ConfigurationController(ConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConfigurationResponseDTO> create(@RequestBody ConfigurationRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{country}")
    public ResponseEntity<ConfigurationResponseDTO> get(@PathVariable String country) {
        return ResponseEntity.ok(service.get(country));
    }


    @PutMapping("/{country}")
    public ResponseEntity<ConfigurationResponseDTO> update(@PathVariable String country, @RequestBody ConfigurationRequestDTO request) {
        return ResponseEntity.ok(service.update(country, request));
    }

}
