package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaAlunoDTO extends AbstractNotaDTO {
    private DisciplinaNotaAlunoDTO disciplina;

}
