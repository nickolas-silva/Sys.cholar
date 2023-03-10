package br.edu.ufersa.sys_scholar.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nome;
    @NonNull
    private String turno;
    @NonNull
    private Integer horario;
    @NonNull
    private Integer sala;

    @JsonIgnore
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
    List<Nota> notas;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    Professor professor;

    // @ManyToMany
    // @JoinTable(
    // name = "aluno_disciplina",
    // joinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName =
    // "id"),
    // inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName =
    // "id")
    // )
    // private Set<Aluno> alunos;

}
