package DS.SAGSA.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DS.SAGSA.models.DOCUMENTOS;

@Repository
public interface DOCUMENTOSRepository extends JpaRepository<DOCUMENTOS, Long> {

    // Lista todos os documentos associados a um utilizador específico
    List<DOCUMENTOS> findByIdUsuario(Long idUsuario);
}