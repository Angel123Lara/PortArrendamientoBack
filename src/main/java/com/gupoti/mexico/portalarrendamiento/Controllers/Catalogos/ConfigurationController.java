package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConfigurationResponseDTO;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;
import java.util.List;

//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/catalogs/configurations")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;


//---------Obtiene una lista de todas las configuraciones disponibles. No requiere un ID porque no se enfoca en un elemento específico------------------------------
    @GetMapping
    public ResponseEntity<List<ConfigurationResponseDTO>> getAllConfigurations() {
        List<ConfigurationResponseDTO> configurations = configurationService.getAllConfigurations();
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }



//---------Obtiene una configuración específica por su ID. Es una operación de solo lectura que no modifica datos------------------------------
   /*  @GetMapping("/{id}")
    public ResponseEntity<ConfigurationResponseDTO> getConfigurationById(@PathVariable Long id) {
        ConfigurationResponseDTO configuration = configurationService.getConfigurationById(id);
        return new ResponseEntity<>(configuration, HttpStatus.OK);
    }*/ 



//---------Crea una nueva configuración. No se necesita un ID porque se generará uno nuevo para la configuración creada------------------------------
    @PostMapping
    public ResponseEntity<ConfigurationResponseDTO> createConfiguration(
          @Valid  @RequestBody ConfigurationRequestDTO configurationRequestDTO) {
        ConfigurationResponseDTO configuration = configurationService.createConfiguration(configurationRequestDTO);
        return new ResponseEntity<>(configuration, HttpStatus.CREATED);
    }



//-------Actualiza una configuración existente identificada por el ID. Reemplaza todos los datos de la configuración con los nuevos proporcionados.--------------------------------
   /*  @PutMapping("/{id}")
    public ResponseEntity<ConfigurationResponseDTO> updateConfiguration(@PathVariable Long id,
            @RequestBody ConfigurationRequestDTO configurationRequestDTO) {
        ConfigurationResponseDTO configuration = configurationService.updateConfiguration(id, configurationRequestDTO);
        return new ResponseEntity<>(configuration, HttpStatus.OK);
    } */ 


}
