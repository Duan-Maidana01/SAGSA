package DS.SAGSA.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.SAPZ;
import DS.SAGSA.Repositories.SAPZRepository;

@Service
public class SAPZService {

    @Autowired
    private SAPZRepository sapzRepository;

    public List<SAPZ> listarTodos() {
        return this.sapzRepository.findAll();
    }

    public Optional<SAPZ> buscarPorId(Integer id) {
        return this.sapzRepository.findById(Long.valueOf(id));
    }

    public List<SAPZ> buscarPorProfessor(Integer idProfessor) {
        return this.sapzRepository.findByProfessorIdProfessor(idProfessor);
    }

    @Transactional
    public SAPZ cadastrarSAPZ(SAPZ sapz) {
        if (sapz.getDataCadastro() == null) {
            sapz.setDataCadastro(LocalDate.now());
        }
        if (sapz.getStatus() == null) {
            sapz.setStatus("EM_ANALISE");
        }
        return this.sapzRepository.save(sapz);
    }

    @Transactional
    public SAPZ atualizar(Integer id, SAPZ sapzAtualizado) {
        SAPZ sapz = buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("SAPZ não encontrado com o ID: " + id));

        sapz.setCodigo(sapzAtualizado.getCodigo());
        sapz.setDescricao(sapzAtualizado.getDescricao());
        sapz.setStatus(sapzAtualizado.getStatus());
        if (sapzAtualizado.getProfessor() != null) {
            sapz.setProfessor(sapzAtualizado.getProfessor());
        }

        return this.sapzRepository.save(sapz);
    }

    public void deletar(Integer id) {
        buscarPorId(id).orElseThrow(() -> new RuntimeException("SAPZ não encontrado com o ID: " + id));
        try {
            this.sapzRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o registro SAPZ!");
        }
    }
}