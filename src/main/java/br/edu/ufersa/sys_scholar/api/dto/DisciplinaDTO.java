package br.edu.ufersa.sys_scholar.api.dto;

import java.util.ArrayList;
import java.util.List;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
public class DisciplinaDTO implements InterfaceDTO<Disciplina> {

    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    private String turno;
    private Integer horario;
    private Integer sala;
    private List<NotaDTO> notas;

    private List<NotaDTO> convertToNotasDTO(List<Nota> notas) {
        List<NotaDTO> listNotaDTOs = new ArrayList<>();
        for (Nota nota : notas) {
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.getData(nota);
            listNotaDTOs.add(notaDTO);
        }
        return listNotaDTOs;
    }

    public void getData(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.turno = disciplina.getTurno();
        this.horario = disciplina.getHorario();
        this.sala = disciplina.getSala();
        this.notas = convertToNotasDTO(disciplina.getNotas());
    }

    public Disciplina convert() {
        Disciplina disciplina = new Disciplina();

        disciplina.setId(id);
        disciplina.setNome(nome);
        disciplina.setTurno(turno);
        disciplina.setHorario(horario);
        disciplina.setSala(sala);
        return disciplina;
    }
}
