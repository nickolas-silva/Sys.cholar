package br.edu.ufersa.sys_scholar.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NonNull
    // private Integer codigo;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_id", referencedColumnName = "id")
    private Codigo codigo;

    private String nome;

    @Column(unique = true)
    private Long cpf;

    // @Column(unique = true)
    // private String usuario;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    private String senha;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    List<Nota> notas;

    // @JsonIgnore
    // @ManyToMany
    // @JoinTable(
    // name = "aluno_disciplina",
    // joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
    // inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName
    // = "id")
    // )
    // private Set<Disciplina> disciplinas;

}
