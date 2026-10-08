package DS.SAGSA.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Integer idProfessor;

    @Column(name = "matricula")
    private Integer matricula;

    @Column(name = "departamento", length = 100)
    private String departamento;

    @Column(name = "titulacao", length = 100)
    private String titulacao;

    public Professor() { }

    public Professor(Integer matricula, String departamento, String titulacao) {
        this.matricula = matricula;
        this.departamento = departamento;
        this.titulacao = titulacao;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}