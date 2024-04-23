package com.gupoti.mexico.portalarrendamiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gupoti.mexico.portalarrendamiento.Model.C_ConfigurationModel;

@Repository
public interface C_ConfigurationRepo extends JpaRepository<C_ConfigurationModel, Long>{

}
