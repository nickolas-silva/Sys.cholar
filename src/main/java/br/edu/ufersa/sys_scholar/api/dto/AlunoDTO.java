package br.edu.ufersa.sys_scholar.api.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


@Getter
@Setter
public class AlunoDTO implements InterfaceDTO<Aluno>{
    
    @Setter(AccessLevel.NONE)
    private Long id;
    
    private Integer codigo;
    
    private String nome;

    @JsonIgnore
    private Integer cpf;
    
    @JsonIgnore
    private String usuario;
    
    @JsonIgnore
    private String senha;

    @JsonIgnore
    private EnderecoDTO endereco;
   
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
