package DS.SAGSA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.Administrador;
import DS.SAGSA.Repositories.AdministradorRepository;

@Service
public class AdministradorService {

    @Autowired 
    private AdministradorRepository administradorRepository;

    public Administrador buscarAdministradorPorId(Long id) {
        Optional<Administrador> administrador = this.administradorRepository.findById(id);
        return administrador.orElseThrow(() -> new RuntimeException("Administrador não encontrado!"));
    }

    public Administrador buscarAdministradorPorUsuario(Long userId) {
        Optional<Administrador> administrador = this.administradorRepository.findByIdUsuario(userId);
        return administrador.orElseThrow(() -> new RuntimeException("Administrador não encontrado para este utilizador!"));
    }

    public List<Administrador> listarTodos() {
        return this.administradorRepository.findAll();
    }

    @Transactional
    public Administrador salvarAdministrador(Administrador obj) {
        obj.setIdAdministrador(null);
        return this.administradorRepository.save(obj);
    }

    @Transactional
    public Administrador atualizar(Administrador obj) {
        Administrador newObj = buscarAdministradorPorId(obj.getIdAdministrador());
        newObj.setNomeAdministrador(obj.getNomeAdministrador());
        newObj.setEmailAdministrador(obj.getEmailAdministrador());
        if (obj.getIdUsuario() != null) {
            newObj.setIdUsuario(obj.getIdUsuario());
        }
        return this.administradorRepository.save(newObj);
    }

    public void deletar(Long id) {
        buscarAdministradorPorId(id);
        try {
            this.administradorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois existem entidades relacionadas!");
        }
    }
}