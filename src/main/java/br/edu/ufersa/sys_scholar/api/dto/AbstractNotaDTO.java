package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
public abstract class AbstractNotaDTO implements InterfaceDTO<Nota> {

    protected Long id;
    protected Double nota01;
    protected Double nota02;
    protected Double nota03;
    protected Double nota04;
    protected Double media;
    protected Double exameFinal;
    protected Double mediaFinal;

    @Override
    public Nota convert() {
        Nota nota = new Nota();
        nota.setId(id);
        nota.setNota01(nota01);
        nota.setNota02(nota02);
        nota.setNota03(nota03);
        nota.setNota04(nota04);
        nota.setMedia(media);
        nota.setExameFinal(exameFinal);
        nota.setMediaFinal(mediaFinal);

        // if (disciplina != null) {
        // nota.setDisciplina(disciplina.convert());
        // }

        // if (aluno != null) {
        // nota.setAluno(aluno.convert());
        // }

        return nota;
    }

    @Override
    public void setData(Nota nota) {
        this.id = nota.getId();
        this.nota01 = nota.getNota01();
        this.nota02 = nota.getNota02();
        this.nota03 = nota.getNota03();
        this.nota04 = nota.getNota04();
        this.media = nota.getMedia();
        this.exameFinal = nota.getExameFinal();
        this.mediaFinal = nota.getMediaFinal();

        // DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        // disciplinaDTO.getData(nota.getDisciplina());
        // this.disciplina = disciplinaDTO;

        // AlunoDTO alunoDTO = new AlunoDTO();
        // alunoDTO.getData(nota.getAluno());
        // this.aluno = alunoDTO;

    }

}
