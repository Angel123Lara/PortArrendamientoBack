package com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConceptModel;

@Repository
public interface ConceptRepository extends JpaRepository<ConceptModel, Long> {
}