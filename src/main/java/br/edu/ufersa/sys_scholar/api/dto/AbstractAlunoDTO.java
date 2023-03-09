package br.edu.ufersa.sys_scholar.api.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
public abstract class AbstractAlunoDTO implements InterfaceDTO<Aluno> {

    protected Long id;

    protected Integer codigo;

    protected String nome;

    @Override
    public Aluno convert() {
        Aluno aluno = new Aluno();
        aluno.setId(this.id);
        aluno.setCodigo(this.codigo);
        aluno.setNome(this.nome);
        aluno.setNotas(new ArrayList<>());
        return aluno;
    }

    @Override
    public void setData(Aluno aluno) {
        this.id = aluno.getId();
        this.codigo = aluno.getCodigo();
        this.nome = aluno.getNome();
    }

}
