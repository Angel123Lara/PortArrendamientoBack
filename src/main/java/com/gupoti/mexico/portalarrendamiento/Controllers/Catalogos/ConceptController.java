package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;
import org.springframework.web.bind.annotation.RestController;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConceptService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptRequestDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/catalogs/concept")
public class ConceptController {

    private  ConceptService conceptService;
    public ConceptController (ConceptService conceptService){
        this.conceptService=conceptService;
    }


   @GetMapping
    public ResponseEntity<List<ConceptDTO>> getConceptAll() {
        List<ConceptDTO> concept = conceptService.getConceptAll();
        return new ResponseEntity<>(concept,HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ConceptDTO> save(@Valid @RequestBody ConceptRequestDTO request) {
        ConceptDTO savedConcept = conceptService.save(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedConcept);
    }

     @PutMapping("/{id}")
    public ResponseEntity<ConceptDTO> updateConcept(@PathVariable Long id, @RequestBody ConceptRequestDTO Data) {
        ConceptDTO updatedConcept = conceptService.updateConcept(id, Data);
        return ResponseEntity.ok(updatedConcept);
    }



}

