package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaDisciplinaDTO extends AbstractNotaDTO {

    // Implementar aluno para essa classe que não tem notas

    private AlunoDisciplinaDTO aluno;

}
