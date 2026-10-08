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

import jakarta.Validation.Valid;
import DS.SAGSA.models.Professor;
import DS.SAGSA.Services.ProfessorService;

@RestController 
@RequestMapping ("/professores")
@Validated 
public class ProfessorController {

    @Autowired 
    private ProfessorService professorService;

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Integer id) {
        Professor obj = this.professorService.buscarProfessorPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping ("/user/{userId}")
    public ResponseEntity<List<Professor>> buscarProfessoresPorUsuario(@PathVariable Long userId) {
        List<Professor> professores = this.professorService.buscarProfessoresPorUsuario(userId);
        return ResponseEntity.ok().body(professores);
    }
    
    @PostMapping
    public ResponseEntity<Professor> salvarProfessor(@Valid @RequestBody Professor obj) {
        this.professorService.salvarProfessor(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@Valid @RequestBody Professor obj, @PathVariable Integer id) {
        obj.setId(id);
        this.professorService.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        this.professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}