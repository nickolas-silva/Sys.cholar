package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
public class NotaDTO implements InterfaceDTO<Nota> {

    @Setter(AccessLevel.NONE)
    private Long id;
    private Double nota01;
    private Double nota02;
    private Double nota03;
    private Double nota04;
    private Double media;
    private Double exameFinal;
    private Double mediaFinal;
    private AlunoDTO aluno;

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

        if (aluno != null) {
            nota.setAluno(aluno.convert());
        }

        return nota;
    }

    @Override
    public void getData(Nota nota) {
        this.id = nota.getId();
        this.nota01 = nota.getNota01();
        this.nota02 = nota.getNota02();
        this.nota03 = nota.getNota03();
        this.nota04 = nota.getNota04();
        this.media = nota.getMedia();
        this.exameFinal = nota.getExameFinal();
        this.mediaFinal = nota.getMediaFinal();
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.getData(nota.getAluno());
        this.aluno = alunoDTO;
    }

}
