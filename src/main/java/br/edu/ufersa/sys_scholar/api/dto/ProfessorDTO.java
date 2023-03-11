package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO implements InterfaceDTO<Professor>{

  private Long id;
  private Integer codigo;
  private String nome;
  private Integer cpf;
  private EnderecoDTO endereco;
  private String usuario;
  private String senha;
  private List<Disciplina> disciplinas;
  @Override
  public Professor convert() {
    Professor professor = new Professor();
    professor.setId(this.id);
    professor.setCodigo(this.codigo);
    professor.setNome(this.nome);
    professor.setCpf(this.cpf);
    professor.setEndereco(this.endereco.convert());
    return professor;
  }

  @Override
  public void setData(Professor professor) {
    this.id = professor.getId();
    this.codigo = professor.getCodigo();
    this.nome = professor.getNome();
    this.cpf = professor.getCpf();
    EnderecoDTO enderecoDTO = new EnderecoDTO();
    enderecoDTO.setData(professor.getEndereco());
    this.endereco = enderecoDTO;
  }
  
}
