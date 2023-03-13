package br.edu.ufersa.sys_scholar.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "codigo_id", referencedColumnName = "id")
  private Codigo codigo;

  private String nome;
  private Integer cpf;

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "usuario_id", referencedColumnName = "id")
  private Usuario usuario;

  private String senha;

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  @JsonIgnore
  @OneToMany(mappedBy = "professor")
  List<Disciplina> disciplinas;

  // @OneToMany
  // @JoinColumn(name = "nota_id", referencedColumnName = "id")
  // List<Nota> notas;

}