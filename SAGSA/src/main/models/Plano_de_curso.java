package DS.SAGSA.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Plano_de_curso")
public class PlanoDeCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano_curso")
    private Integer idPlanoCurso;

    @Column(name = "codigo_disciplina", length = 50)
    private String codigoDisciplina;

    @Column(name = "nome_disciplina", length = 100)
    private String nomeDisciplina;

    @Column(name = "ementa", columnDefinition = "TEXT")
    private String ementa;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "periodo_letivo", length = 50)
    private String periodoLetivo;

    @ManyToOne
    @JoinColumn(name = "fk_Professor_id_professor")
    private Professor professor;

    public PlanoDeCurso() {}

    public Integer getIdPlanoCurso() {
        return idPlanoCurso;
    }

    public void setIdPlanoCurso(Integer idPlanoCurso) {
        this.idPlanoCurso = idPlanoCurso;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}