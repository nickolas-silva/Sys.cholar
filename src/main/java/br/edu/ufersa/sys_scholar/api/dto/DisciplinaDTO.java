package br.edu.ufersa.sys_scholar.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaDTO extends AbstractDisciplinaDTO {

    private List<NotaDisciplinaDTO> notas;

    private List<NotaDisciplinaDTO> convertToNotaDisciplinaDTOs(List<Nota> notas) {
        List<NotaDisciplinaDTO> notaDisciplinaDTOs = new ArrayList<>();

        for (Nota nota : notas) {
            NotaDisciplinaDTO notaDisciplinaDTO = new NotaDisciplinaDTO();
            notaDisciplinaDTO.setData(nota);
            notaDisciplinaDTOs.add(notaDisciplinaDTO);
        }

        return notaDisciplinaDTOs;
    }

    public void setData(Disciplina disciplina) {
        super.setData(disciplina);
        this.notas = convertToNotaDisciplinaDTOs(disciplina.getNotas());
    }

}
