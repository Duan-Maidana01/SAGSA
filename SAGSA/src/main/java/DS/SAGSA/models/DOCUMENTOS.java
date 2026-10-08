// Define o pacote ao qual esta classe pertence (pasta Models dentro do projeto)
package DS.SAGSA.models;

// Importa a classe LocalDate para podermos trabalhar com datas (ano, mês, dia) sem hora
import java.time.LocalDate;

// Declaração da classe publica DOCUMENTOS que representa a entidade/tabela do banco de dados
public class DOCUMENTOS { 

    // --- ATRIBUTOS (Campos que correspondem às colunas da tabela DOCUMENTOS) ---
    private int idDocumento;        // Corresponde à Chave Primária (id_documento)
    private String tipoDocumento;   // Corresponde à coluna tipo_documento (ex: "Relatório", "Atestado")
    private String caminhoArquivo;  // Corresponde à coluna caminho_arquivo (caminho/URL do arquivo)
    private LocalDate dataGeracao;  // Corresponde à coluna data_geracao (data em que foi criado)
    private int idUsuario;          // Corresponde à Chave Estrangeira (FK_Usuario_id_usuario)


    // --- CONSTRUTORES ---

    // Construtor padrão (sem parâmetros)
    // Necessário para frameworks Java criarem objetos vazios antes de preenchê-los
    public DOCUMENTOS() {} 

    // Construtor completo com todos os parâmetros
    // Permite criar um objeto Documento preenchendo todos os dados de uma só vez
    public DOCUMENTOS(int idDocumento, String tipoDocumento, String caminhoArquivo, LocalDate dataGeracao, int idUsuario) {
        this.idDocumento = idDocumento;
        this.tipoDocumento = tipoDocumento;
        this.caminhoArquivo = caminhoArquivo;
        this.dataGeracao = dataGeracao;
        this.idUsuario = idUsuario;
    }


    // --- MÉTODOS GETTERS E SETTERS ---
    // Servem para acessar (Get) e alterar (Set) os atributos privados com segurança (Encapsulamento)

    // Obtém o ID do documento
    public int getIdDocumento() { 
        return idDocumento; 
    }
    
    // Define/Altera o ID do documento
    public void setIdDocumento(int idDocumento) { 
        this.idDocumento = idDocumento; 
    }

    // Obtém o tipo do documento
    public String getTipoDocumento() { 
        return tipoDocumento; 
    }
    
    // Define/Altera o tipo do documento
    public void setTipoDocumento(String tipoDocumento) { 
        this.tipoDocumento = tipoDocumento; 
    }

    // Obtém o caminho do arquivo no disco
    public String getCaminhoArquivo() { 
        return caminhoArquivo; 
    }
    
    // Define/Altera o caminho do arquivo
    public void setCaminhoArquivo(String caminhoArquivo) { 
        this.caminhoArquivo = caminhoArquivo; 
    }

    // Obtém a data de geração do documento
    public LocalDate getDataGeracao() { 
        return dataGeracao; 
    }
    
    // Define/Altera a data de geração
    public void setDataGeracao(LocalDate dataGeracao) { 
        this.dataGeracao = dataGeracao; 
    }

    // Obtém o ID do usuário associado ao documento
    public int getIdUsuario() { 
        return idUsuario; 
    }
    
    // Define/Altera o ID do usuário associado
    public void setIdUsuario(int idUsuario) { 
        this.idUsuario = idUsuario; 
    }
}