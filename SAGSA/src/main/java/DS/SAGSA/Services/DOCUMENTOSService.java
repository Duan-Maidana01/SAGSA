package DS.SAGSA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DS.SAGSA.models.DOCUMENTOS;
import DS.SAGSA.repositories.DOCUMENTOSRepository;

@Service
public class DOCUMENTOSService {

    @Autowired 
    private DOCUMENTOSRepository documentosRepository;

    @Autowired 
    private UsuarioService usuarioService;

    public DOCUMENTOS buscarDocumentosPorId(Long id) {

        Optional<DOCUMENTOS> documentos = this.documentosRepository.findById(id);
        return documentos.orElseThrow(() -> new RuntimeException("Documento não encontrado!"));
    }
    
}