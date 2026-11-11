package com.DS.SAGSA.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import com.DS.SAGSA.models.Escola;
import com.DS.SAGSA.models.dtos.EscolaRequestDTO;
import com.DS.SAGSA.models.dtos.EscolaResponseDTO;
import com.DS.SAGSA.services.EscolaService;

@RestController
@RequestMapping("/escolas")
@Validated
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @GetMapping
    public ResponseEntity<List<EscolaResponseDTO>> findAll() {
        List<EscolaResponseDTO> list = this.escolaService.findAll().stream().map(EscolaResponseDTO::fromEntity).toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscolaResponseDTO> findById(@PathVariable Long id) {
        Escola obj = this.escolaService.findById(id);
        return ResponseEntity.ok().body(EscolaResponseDTO.fromEntity(obj));
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody EscolaRequestDTO objDto) {
        Escola obj = this.escolaService.fromDTO(objDto);
        Escola newObj = this.escolaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody EscolaRequestDTO objDto, @PathVariable Long id) {
        Escola obj = this.escolaService.fromDTO(objDto);
        obj.setId(id);
        this.escolaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.escolaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
