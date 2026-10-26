package DS.SAGSA.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DS.SAGSA.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Procura um utilizador pelo seu endereço de e-mail (usado no login e validações)
    Optional<Usuario> findByEmail(String email);
}