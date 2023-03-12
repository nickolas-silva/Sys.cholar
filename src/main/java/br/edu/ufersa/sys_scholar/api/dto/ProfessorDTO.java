package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {
  private Long id;
  private Integer codigo;
  private String nome;
  private Integer cpf;
  private EnderecoDTO endereco;
  private String usuario;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String senha;
  private List<Disciplina> disciplinas;
}
