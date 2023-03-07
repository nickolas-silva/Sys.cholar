package br.edu.ufersa.sys_scholar.domain.entity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Aluno {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Integer codigo;
    private String nome;
    private Integer cpf;
    private String usuario;
    private String senha;

    @OneToOne(optional = false)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany
    @JoinColumn(name = "nota_id", referencedColumnName = "id")
    List<Nota> notas;

    @ManyToMany
    @JoinTable(
        name = "aluno_disciplina",
        joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id")
    )
    private List<Disciplina> disciplinas;

}
