package com.gupoti.mexico.portalarrendamiento.Service.Catalogos;

import java.util.List;

import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptRequestDTO;


public interface ConceptService {

    ConceptDTO save(ConceptRequestDTO data);

    List<ConceptDTO> getConceptAll();

    ConceptDTO updateConcept(Long id, ConceptRequestDTO concepttDTO);

}
    

