package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaAlunoDTO extends AbstractNotaDTO {
    private DisciplinaNotaAlunoDTO disciplina;

}
