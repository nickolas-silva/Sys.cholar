package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractAlunoDTO {

    protected Long id;

    protected Integer codigo;

    protected String nome;
}
