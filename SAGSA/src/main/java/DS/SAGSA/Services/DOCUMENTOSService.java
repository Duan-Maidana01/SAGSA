package DS.SAGSA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.DOCUMENTOS;
import DS.SAGSA.Repositories.DOCUMENTOSRepository;

@Service
public class DOCUMENTOSService {

    @Autowired 
    private DOCUMENTOSRepository documentosRepository;

    public DOCUMENTOS buscarDocumentosPorId(Long id) {
        Optional<DOCUMENTOS> documentos = this.documentosRepository.findById(id);
        return documentos.orElseThrow(() -> new RuntimeException("Documento não encontrado!"));
    }

    public List<DOCUMENTOS> BuscarDocumentosPorUsuario(Long userId) {
        return this.documentosRepository.findByIdUsuario(userId);
    }

    public List<DOCUMENTOS> listarTodos() {
        return this.documentosRepository.findAll();
    }

    @Transactional
    public DOCUMENTOS salvarDocumentos(DOCUMENTOS obj) {
        return this.documentosRepository.save(obj);
    }

    @Transactional
    public DOCUMENTOS atualizar(DOCUMENTOS obj) {
        DOCUMENTOS newObj = buscarDocumentosPorId((long) obj.getIdDocumento());
        newObj.setTipoDocumento(obj.getTipoDocumento());
        newObj.setCaminhoArquivo(obj.getCaminhoArquivo());
        newObj.setDataGeracao(obj.getDataGeracao());
        if (obj.getIdUsuario() > 0) {
            newObj.setIdUsuario(obj.getIdUsuario());
        }
        return this.documentosRepository.save(newObj);
    }

    public void deletar(Long id) {
        buscarDocumentosPorId(id);
        try {
            this.documentosRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o documento!");
        }
    }
}