package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDisciplinaDTO extends AbstractBaseDisciplinaDTO {
    protected List<NotaDisciplinaDTO> notas;
}
