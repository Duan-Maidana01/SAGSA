package DS.SAGSA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.Usuario;
import DS.SAGSA.Repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> autenticar(String email, String senha) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getSenha().equals(senha) && !"INATIVO".equalsIgnoreCase(usuario.getStatus())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return this.usuarioRepository.findById(Long.valueOf(id));
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        if (usuario.getStatus() == null) {
            usuario.setStatus("ATIVO");
        }
        return this.usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario atualizar(Integer id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Utilizador não encontrado com o ID: " + id));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setPerfil(usuarioAtualizado.getPerfil());
        usuario.setStatus(usuarioAtualizado.getStatus());
        if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
            usuario.setSenha(usuarioAtualizado.getSenha());
        }
        if (usuarioAtualizado.getProfessor() != null) {
            usuario.setProfessor(usuarioAtualizado.getProfessor());
        }

        return this.usuarioRepository.save(usuario);
    }

    public void deletar(Integer id) {
        buscarPorId(id).orElseThrow(() -> new RuntimeException("Utilizador não encontrado com o ID: " + id));
        try {
            this.usuarioRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o utilizador pois existem registros associados!");
        }
    }
}