package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaDTO extends AbstractDisciplinaDTO {

    private ProfessorDisciplinaDTO professor;

}
