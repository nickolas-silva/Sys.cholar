package br.edu.ufersa.sys_scholar.domain.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
}
