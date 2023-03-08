package br.edu.ufersa.sys_scholar.api.dto;
import java.io.Serializable;
import java.util.List;

import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import ch.qos.logback.core.joran.action.NewRuleAction;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AlunoDTO implements InterfaceDTO<Aluno>{
    
    private Long id;
    
    private Integer codigo;
    
    private String nome;

    private Integer cpf;
    
    private String usuario;
    
    private String senha;

    private EnderecoDTO endereco;

    private List<Nota> notas;

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
    public void getData(Aluno aluno) {
        this.id = aluno.getId();
        this.codigo = aluno.getCodigo();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.getData(aluno.getEndereco());
        this.endereco = enderecoDTO;
    }

}
