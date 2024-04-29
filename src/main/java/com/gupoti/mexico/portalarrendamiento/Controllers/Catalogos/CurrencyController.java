package com.gupoti.mexico.portalarrendamiento.Controllers.Catalogos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.CurrencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catalogs/currency")
public class CurrencyController {
    
    @Autowired
    private CurrencyService service;

    @PostMapping("/save")
    public ResponseEntity<CurrencyDTO> save(@Valid @RequestBody CurrencyRequestDTO data)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(data));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CurrencyDTO>> findAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping("enabled/{id}")
    public ResponseEntity<CurrencyDTO> enabledById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.enabledById(id));

    @PatchMapping("/{id}")
    public ResponseEntity<CurrencyDTO> update(@PathVariable("id") long id, @Valid @RequestBody CurrencyRequestDTO data)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, data));

    }
}
