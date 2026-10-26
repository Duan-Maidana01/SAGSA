package DS.SAGSA.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DS.SAGSA.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    // Procura professores associados ao ID de utilizador
    List<Professor> findByIdUsuario(Long idUsuario);
}