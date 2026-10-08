package DS.SAGSA.Controller;

import DS.SAGSA.models.PlanoDeCurso;
import DS.SAGSA.Service.PlanoDeCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos-de-curso")
public class PlanoDeCursoController {

    @Autowired
    private PlanoDeCursoService planoDeCursoService;

    @GetMapping
    public ResponseEntity<List<PlanoDeCurso>> listar() {
        return ResponseEntity.ok(planoDeCursoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDeCurso> buscarPorId(@PathVariable Integer id) {
        return planoDeCursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/professor/{idProfessor}")
    public ResponseEntity<List<PlanoDeCurso>> buscarPorProfessor(@PathVariable Integer idProfessor) {
        return ResponseEntity.ok(planoDeCursoService.buscarPorProfessor(idProfessor));
    }

    @PostMapping
    public ResponseEntity<PlanoDeCurso> criar(@RequestBody PlanoDeCurso plano) {
        PlanoDeCurso novoPlano = planoDeCursoService.salvar(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPlano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDeCurso> atualizar(@PathVariable Integer id, @RequestBody PlanoDeCurso plano) {
        try {
            PlanoDeCurso planoAtualizado = planoDeCursoService.atualizar(id, plano);
            return ResponseEntity.ok(planoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        planoDeCursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}