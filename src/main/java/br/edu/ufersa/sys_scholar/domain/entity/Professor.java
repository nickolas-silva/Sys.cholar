package br.edu.ufersa.sys_scholar.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer codigo;
  private String nome;
  private Integer cpf;
  private String usuario;
  private String senha;

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  // @OneToMany
  // @JoinColumn(name = "nota_id", referencedColumnName = "id")
  // List<Nota> notas;

  @OneToMany
  @JoinTable(name = "professor_disciplina", joinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"))
  private List<Disciplina> disciplinas;

}