package br.edu.ufersa.sys_scholar.domain.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
public class Disciplina {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String turno;
    private Integer horario;
    private Integer sala;

    @ManyToMany
    @JoinTable(
        name = "aluno_disciplina",
        joinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    )
    private List<Aluno> alunos;


        
}
