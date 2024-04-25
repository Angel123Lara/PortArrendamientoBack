package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;
import org.springframework.web.bind.annotation.RestController;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConceptService;

import jakarta.validation.Valid;

import org.apache.commons.lang3.Validate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptRequestDTO;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/catalogs/concept")
public class ConceptController {

    private  ConceptService conceptService;
    public ConceptController (ConceptService conceptService){
        this.conceptService=conceptService;
    }

    @PostMapping
    public ResponseEntity<ConceptDTO> save(@Valid @RequestBody ConceptRequestDTO request) {
        ConceptDTO savedConcept = conceptService.save(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedConcept);
    }


}

