package DS.SAGSA.Controller;

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
import DS.SAGSA.models.Administrador;
import DS.SAGSA.Services.AdministradorService;

@RestController
@RequestMapping("/administrador")
@Validated
public class AdministradorController {
    
    @Autowired 
    private AdministradorService administradorService;

    // Buscar administrador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscarAdministradorPorId(@PathVariable Long id) {
        Administrador obj = this.administradorService.buscarAdministradorPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    // Buscar administrador por ID de Usuário
    @GetMapping("/user/{userId}")
    public ResponseEntity<Administrador> buscarAdministradorPorUsuario(@PathVariable Long userId) {
        Administrador obj = this.administradorService.buscarAdministradorPorUsuario(userId);
        return ResponseEntity.ok().body(obj);
    }

    // Criar/Salvar novo administrador
    @PostMapping
    public ResponseEntity<Void> salvarAdministrador(@Valid @RequestBody Administrador obj) {
        this.administradorService.salvarAdministrador(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdAdministrador()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // Atualizar administrador existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody Administrador obj, @PathVariable Long id) {
        obj.setIdAdministrador(id);
        this.administradorService.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    // Deletar administrador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.administradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}