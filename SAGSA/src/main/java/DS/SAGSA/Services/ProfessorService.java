package DS.SAGSA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.Professor;
import DS.SAGSA.Repositories.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor buscarProfessorPorId(Integer id) {
        Optional<Professor> professor = this.professorRepository.findById(Long.valueOf(id));
        return professor.orElseThrow(() -> new RuntimeException("Professor não encontrado!"));
    }

    public List<Professor> buscarProfessoresPorUsuario(Long userId) {
        return this.professorRepository.findByIdUsuario(userId);
    }

    public List<Professor> listarTodos() {
        return this.professorRepository.findAll();
    }

    @Transactional
    public Professor salvarProfessor(Professor obj) {
        return this.professorRepository.save(obj);
    }

    @Transactional
    public Professor atualizar(Professor obj) {
        Professor newObj = buscarProfessorPorId(obj.getIdProfessor());
        newObj.setMatricula(obj.getMatricula());
        newObj.setDepartamento(obj.getDepartamento());
        newObj.setTitulacao(obj.getTitulacao());
        return this.professorRepository.save(newObj);
    }

    public void deletar(Integer id) {
        buscarProfessorPorId(id);
        try {
            this.professorRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o professor pois existem registros associados!");
        }
    }
}