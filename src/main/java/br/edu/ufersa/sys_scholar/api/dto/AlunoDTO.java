package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO extends AbstractAlunoDTO {

    protected Integer cpf;
    protected String usuario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String senha;
    protected EnderecoDTO endereco;
    private List<NotaAlunoDTO> notas;

}
