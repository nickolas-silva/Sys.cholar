package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaDisciplinaDTO extends AbstractNotaDTO {

    // Implementar aluno para essa classe que não tem notas

    private AlunoDisciplinaDTO aluno;

    public Nota convert() {
        Nota nota = super.convert();
        nota.setAluno(aluno.convert());
        return nota;
    }

    public void setData(Nota nota) {
        super.setData(nota);
        AlunoDisciplinaDTO alunoDisciplinaDTO = new AlunoDisciplinaDTO();
        alunoDisciplinaDTO.setData(nota.getAluno());
        this.aluno = alunoDisciplinaDTO;
    }
}
