package DS.SAGSA.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DS.SAGSA.models.SAPZ;

@Repository
public interface SAPZRepository extends JpaRepository<SAPZ, Long> {

    // Procura registos de SAPZ vinculados ao ID de um professor
    List<SAPZ> findByProfessorIdProfessor(Integer idProfessor);
}