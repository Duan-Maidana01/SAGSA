package DS.SAGSA.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DS.SAGSA.models.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    // Procura o administrador através do ID do utilizador associado
    Optional<Administrador> findByIdUsuario(Long idUsuario);
}