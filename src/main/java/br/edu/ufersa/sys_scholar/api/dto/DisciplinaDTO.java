package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaDTO extends AbstractDisciplinaDTO {

    private List<NotaDisciplinaDTO> notas;

}
