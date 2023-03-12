package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
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
  private String senha;
  private List<Disciplina> disciplinas;
}
