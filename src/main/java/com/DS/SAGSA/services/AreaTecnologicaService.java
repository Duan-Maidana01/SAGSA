package com.DS.SAGSA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

import com.DS.SAGSA.models.AreaTecnologica;
import com.DS.SAGSA.models.dtos.AreaTecnologicaRequestDTO;
import com.DS.SAGSA.repositories.AreaTecnologicaRepository;
import com.DS.SAGSA.services.exceptions.DataBindingViolationException;
import com.DS.SAGSA.services.exceptions.ObjectNotFoundException;

// Regras de negócio de áreas tecnológicas. Leitura: qualquer usuário autenticado. Escrita: ADMIN ou COORDENADOR.
@Service
public class AreaTecnologicaService {

    @Autowired
    private AreaTecnologicaRepository areaTecnologicaRepository;

    @Autowired
    private EixoTecnologicoService eixoTecnologicoService;

    @Transactional(readOnly = true)
    public AreaTecnologica findById(Long id) {
        Optional<AreaTecnologica> areaTecnologica = this.areaTecnologicaRepository.findById(id);
        AreaTecnologica obj = areaTecnologica.orElseThrow(() -> new ObjectNotFoundException(
                "Área tecnológica não encontrada! Id: " + id + ", Tipo: " + AreaTecnologica.class.getName()));
        return obj;
    }

    @Transactional(readOnly = true)
    public List<AreaTecnologica> findAll() {
        return this.areaTecnologicaRepository.findAll(Sort.by("nome"));
    }

    @Transactional(readOnly = true)
    public List<AreaTecnologica> findByEixoTecnologico(Long eixoTecnologicoId) {
        return this.areaTecnologicaRepository.findByEixoTecnologico_IdOrderByNomeAsc(eixoTecnologicoId);
    }

    @Transactional
    public AreaTecnologica create(AreaTecnologica obj) {
        UsuarioService.checkGestao();
        obj.setId(null);
        return this.areaTecnologicaRepository.save(obj);
    }

    @Transactional
    public AreaTecnologica update(AreaTecnologica obj) {
        UsuarioService.checkGestao();
        AreaTecnologica newObj = findById(obj.getId());
        newObj.setEixoTecnologico(obj.getEixoTecnologico());
        newObj.setNome(obj.getNome());
        return this.areaTecnologicaRepository.save(newObj);
    }

    public void delete(Long id) {
        UsuarioService.checkGestao();
        findById(id);
        try {
            this.areaTecnologicaRepository.deleteById(id);
            this.areaTecnologicaRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new DataBindingViolationException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

    public AreaTecnologica fromDTO(@Valid AreaTecnologicaRequestDTO obj) {
        AreaTecnologica areaTecnologica = new AreaTecnologica();
        areaTecnologica.setEixoTecnologico(this.eixoTecnologicoService.findById(obj.getEixoTecnologicoId()));
        areaTecnologica.setNome(obj.getNome());
        return areaTecnologica;
    }
}
