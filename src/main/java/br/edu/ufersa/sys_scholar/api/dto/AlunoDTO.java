package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO extends AbstractAlunoDTO {

    @Min(value = 10000000000L, message = "CPF Inválido")
    @Max(value = 99999999999L, message = "CPF Inválido")
    protected Long cpf;
    protected String usuario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 64, message = "Senha inválida!")
    protected String senha;
    protected EnderecoDTO endereco;
    private List<NotaAlunoDTO> notas;

}
