package br.edu.ufersa.sys_scholar.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO extends AbstractAlunoDTO {
    private List<NotaAlunoDTO> notas;

    private List<NotaAlunoDTO> convertToNotaDTOs(List<Nota> notas) {
        List<NotaAlunoDTO> lisNotaDTOs = new ArrayList<>();

        for (Nota nota : notas) {
            NotaAlunoDTO notaDTO = new NotaAlunoDTO();
            notaDTO.setData(nota);
            lisNotaDTOs.add(notaDTO);
        }

        return lisNotaDTOs;
    }

    public void setData(Aluno aluno) {
        super.setData(aluno);
        this.notas = convertToNotaDTOs(aluno.getNotas());
    }
}
