package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractBaseDisciplinaDTO {

    // @Setter(AccessLevel.NONE)
    protected Long id;
    protected String nome;
    protected String turno;
    protected Integer horario;
    protected Integer sala;

}
