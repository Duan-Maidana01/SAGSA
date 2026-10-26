package DS.SAGSA.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DS.SAGSA.models.PlanoDeCurso;

@Repository
public interface PlanoDeCursoRepository extends JpaRepository<PlanoDeCurso, Long> {

    // Procura planos de curso associados ao ID de um professor
    List<PlanoDeCurso> findByProfessorIdProfessor(Integer idProfessor);
}