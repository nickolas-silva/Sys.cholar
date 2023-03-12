package br.edu.ufersa.sys_scholar.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO extends AbstractProfessorDTO {
    private List<DisciplinaProfessorDTO> disciplinas;
}
