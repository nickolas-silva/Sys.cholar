package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDisciplinaDTO extends AbstractBaseDisciplinaDTO {
    protected ProfessorDTO professor;
}
