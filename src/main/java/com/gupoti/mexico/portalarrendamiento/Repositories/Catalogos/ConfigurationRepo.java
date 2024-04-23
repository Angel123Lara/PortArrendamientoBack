package com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;

@Repository
public interface ConfigurationRepo extends JpaRepository<ConfigurationModel, Long>{

}
