package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaAlunoDTO extends AbstractNotaDTO {
    private DisciplinaNotaAlunoDTO disciplina;

    public Nota convert() {
        Nota nota = super.convert();
        nota.setDisciplina(disciplina.convert());

        return nota;
    }

    public void setData(Nota nota) {
        super.setData(nota);
        DisciplinaNotaAlunoDTO disciplinaDTO = new DisciplinaNotaAlunoDTO();
        disciplinaDTO.setData(nota.getDisciplina());
        this.disciplina = disciplinaDTO;
    }
}
