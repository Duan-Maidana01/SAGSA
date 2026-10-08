// Define o pacote ao qual esta classe pertence (pasta Models dentro do projeto)
package DS.SAGSA.models;

// Declaração da classe publica Administrador que representa a entidade/tabela do banco de dados
public class Administrador { 

    // --- ATRIBUTOS (Campos que correspondem às colunas da tabela Administrador) ---
    private Long idAdministrador;      // Corresponde à Chave Primária (id_Administrador)
    private String nomeAdministrador;  // Corresponde à coluna nome_administrador
    private String emailAdministrador; // Corresponde à coluna email_administrador
    private Long idUsuario;            // Corresponde à Chave Estrangeira (id_usuario)


    
    // --- CONSTRUTORES ---

    // Construtor padrão (sem parâmetros)
    // Necessário para frameworks Java criarem objetos vazios antes de preenchê-los
    public Administrador() {} 

    // Construtor completo com todos os parâmetros
    // Permite criar um objeto Administrador preenchendo todos os dados de uma só vez
    public Administrador(Long idAdministrador, String nomeAdministrador, String emailAdministrador, Long idUsuario) {
        this.idAdministrador = idAdministrador;
        this.nomeAdministrador = nomeAdministrador;
        this.emailAdministrador = emailAdministrador;
        this.idUsuario = idUsuario;
    }


    // --- MÉTODOS GETTERS E SETTERS ---
    // Servem para acessar (Get) e alterar (Set) os atributos privados com segurança (Encapsulamento)

    // Obtém o ID do administrador
    public Long getIdAdministrador() { 
        return idAdministrador; 
    }
    
    // Define/Altera o ID do administrador
    public void setIdAdministrador(Long idAdministrador) { 
        this.idAdministrador = idAdministrador; 
    }

    // Obtém o nome do administrador
    public String getNomeAdministrador() { 
        return nomeAdministrador; 
    }
    
    // Define/Altera o nome do administrador
    public void setNomeAdministrador(String nomeAdministrador) { 
        this.nomeAdministrador = nomeAdministrador; 
    }

    // Obtém o email do administrador
    public String getEmailAdministrador() { 
        return emailAdministrador; 
    }
    
    // Define/Altera o email do administrador
    public void setEmailAdministrador(String emailAdministrador) { 
        this.emailAdministrador = emailAdministrador; 
    }

    // Obtém o ID do usuário associado ao administrador
    public Long getIdUsuario() { 
        return idUsuario; 
    }
    
    // Define/Altera o ID do usuário associado
    public void setIdUsuario(Long idUsuario) { 
        this.idUsuario = idUsuario; 
    }
}