package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

import org.springframework.stereotype.Service;

import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.ConfigurationRepo;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConfigurationServ;

@Service
public class ConfigurationServImpl implements ConfigurationServ {

    private ConfigurationRepo repositorty;

    public ConfigurationServImpl(ConfigurationRepo repository){
        this.repositorty = repository;
    }
    
}
