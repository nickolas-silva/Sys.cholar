package br.edu.ufersa.sys_scholar.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
public abstract class AbstractAlunoDTO implements InterfaceDTO<Aluno> {

    @Setter(AccessLevel.NONE)
    protected Long id;

    protected Integer codigo;

    protected String nome;

    @JsonIgnore
    protected Integer cpf;

    @JsonIgnore
    protected String usuario;

    @JsonIgnore
    protected String senha;

    @JsonIgnore
    protected EnderecoDTO endereco;

    @Override
    public Aluno convert() {
        Aluno aluno = new Aluno();
        aluno.setId(this.id);
        aluno.setCodigo(this.codigo);
        aluno.setNome(this.nome);
        aluno.setCpf(this.cpf);

        return aluno;
    }

    @Override
    public void setData(Aluno aluno) {
        this.id = aluno.getId();
        this.codigo = aluno.getCodigo();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setData(aluno.getEndereco());
        this.endereco = enderecoDTO;
    }

}
