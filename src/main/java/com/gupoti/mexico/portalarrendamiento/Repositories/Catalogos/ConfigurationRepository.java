package com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConfigurationModel;

@SpringBootApplication
@EnableJpaRepositories()

@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationModel, Long> {

    ConfigurationModel findByCountry(String country);

}
