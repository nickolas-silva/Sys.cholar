package br.edu.ufersa.sys_scholar.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiretorDTO {

    private Long id;
    private Integer codigo;
    private String nome;
    private Integer cpf;
    private String usuario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String senha;
}
