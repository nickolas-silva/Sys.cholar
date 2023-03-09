package br.edu.ufersa.sys_scholar.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double nota01;
    private Double nota02;
    private Double nota03;
    private Double nota04;
    private Double media;
    private Double exameFinal;
    private Double mediaFinal;

    // @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    Aluno aluno;

    // @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id")
    private Disciplina disciplina;

}
