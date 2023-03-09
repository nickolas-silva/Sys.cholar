package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
public abstract class AbstractDisciplinaDTO implements InterfaceDTO<Disciplina> {

    @Setter(AccessLevel.NONE)
    protected Long id;
    protected String nome;
    protected String turno;
    protected Integer horario;
    protected Integer sala;

    public void setData(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.turno = disciplina.getTurno();
        this.horario = disciplina.getHorario();
        this.sala = disciplina.getSala();
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
