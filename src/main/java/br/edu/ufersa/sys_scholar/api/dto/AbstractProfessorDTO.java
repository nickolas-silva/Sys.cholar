package br.edu.ufersa.sys_scholar.api.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractProfessorDTO {
  private Long id;
  private Long codigo;
  private String nome;
  @Min(value = 10000000000L, message = "CPF Inválido")
  @Max(value = 99999999999L, message = "CPF Inválido")
  private Long cpf;
  private EnderecoDTO endereco;
  private String usuario;
  @Size(min = 8, max = 64, message = "Senha inválida!")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String senha;
}
