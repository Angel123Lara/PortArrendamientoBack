package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationServ;

@RestController
@RequestMapping("/api/catalogs/configurations")
public class ConfigurationController {
    private ConfigurationServ service;

    public ConfigurationController(ConfigurationServ service){
        this.service = service;
    }
    
}
