package br.edu.ufersa.sys_scholar.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractProfessorDTO {
  private Long id;
  private Long codigo;
  private String nome;
  private Integer cpf;
  private EnderecoDTO endereco;
  private String usuario;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String senha;
}
