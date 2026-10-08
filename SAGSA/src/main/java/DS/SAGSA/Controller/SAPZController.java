package DS.SAGSA.Controller;

import DS.SAGSA.models.SAPZ;
import DS.SAGSA.Service.SAPZService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sapz")
public class SAPZController {

    @Autowired
    private SAPZService sapzService;

    @GetMapping
    public ResponseEntity<List<SAPZ>> listar() {
        return ResponseEntity.ok(sapzService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SAPZ> buscarPorId(@PathVariable Integer id) {
        return sapzService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/professor/{idProfessor}")
    public ResponseEntity<List<SAPZ>> buscarPorProfessor(@PathVariable Integer idProfessor) {
        return ResponseEntity.ok(sapzService.buscarPorProfessor(idProfessor));
    }

    @PostMapping
    public ResponseEntity<SAPZ> cadastrar(@RequestBody SAPZ sapz) {
        SAPZ novoSapz = sapzService.cadastrarSAPZ(sapz);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSapz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SAPZ> atualizar(@PathVariable Integer id, @RequestBody SAPZ sapz) {
        try {
            SAPZ sapzAtualizado = sapzService.atualizar(id, sapz);
            return ResponseEntity.ok(sapzAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        sapzService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}