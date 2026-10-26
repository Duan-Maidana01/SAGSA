package DS.SAGSA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.PlanoDeCurso;
import DS.SAGSA.Repositories.PlanoDeCursoRepository;

@Service
public class PlanoDeCursoService {

    @Autowired
    private PlanoDeCursoRepository planoDeCursoRepository;

    public List<PlanoDeCurso> listarTodos() {
        return this.planoDeCursoRepository.findAll();
    }

    public Optional<PlanoDeCurso> buscarPorId(Integer id) {
        return this.planoDeCursoRepository.findById(Long.valueOf(id));
    }

    public List<PlanoDeCurso> buscarPorProfessor(Integer idProfessor) {
        return this.planoDeCursoRepository.findByProfessorIdProfessor(idProfessor);
    }

    @Transactional
    public PlanoDeCurso salvar(PlanoDeCurso plano) {
        return this.planoDeCursoRepository.save(plano);
    }

    @Transactional
    public PlanoDeCurso atualizar(Integer id, PlanoDeCurso planoAtualizado) {
        PlanoDeCurso plano = buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Plano de Curso não encontrado com o ID: " + id));

        plano.setCodigoDisciplina(planoAtualizado.getCodigoDisciplina());
        plano.setNomeDisciplina(planoAtualizado.getNomeDisciplina());
        plano.setEmenta(planoAtualizado.getEmenta());
        plano.setCargaHoraria(planoAtualizado.getCargaHoraria());
        plano.setPeriodoLetivo(planoAtualizado.getPeriodoLetivo());
        if (planoAtualizado.getProfessor() != null) {
            plano.setProfessor(planoAtualizado.getProfessor());
        }

        return this.planoDeCursoRepository.save(plano);
    }

    public void deletar(Integer id) {
        buscarPorId(id).orElseThrow(() -> new RuntimeException("Plano de Curso não encontrado com o ID: " + id));
        try {
            this.planoDeCursoRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o Plano de Curso!");
        }
    }
}