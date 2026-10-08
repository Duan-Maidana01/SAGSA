package DS.SAGSA.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SAPZ")
public class SAPZ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sapz")
    private Integer idSapz;

    @Column(name = "codigo", length = 50)
    private String codigo;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "status", length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "FK_Professor_id_professor")
    private Professor professor;

    public SAPZ() {}

    public Integer getIdSapz() {
        return idSapz;
    }

    public void setIdSapz(Integer idSapz) {
        this.idSapz = idSapz;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}