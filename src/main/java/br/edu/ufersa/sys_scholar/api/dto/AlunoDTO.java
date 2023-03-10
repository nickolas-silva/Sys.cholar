package br.edu.ufersa.sys_scholar.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO extends AbstractAlunoDTO {

    protected Integer cpf;
    protected String usuario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String senha;
    protected EnderecoDTO endereco;
    private List<NotaAlunoDTO> notas;

    private List<NotaAlunoDTO> convertToNotaDTOs(List<Nota> notas) {
        List<NotaAlunoDTO> lisNotaDTOs = new ArrayList<>();

        for (Nota nota : notas) {
            NotaAlunoDTO notaDTO = new NotaAlunoDTO();
            notaDTO.setData(nota);
            lisNotaDTOs.add(notaDTO);
        }

        return lisNotaDTOs;
    }

    public Aluno convert() {
        Aluno aluno = super.convert();
        aluno.setCpf(this.cpf);
        aluno.setSenha(senha);
        aluno.setUsuario(usuario);
        aluno.setEndereco(new Endereco());
        if (endereco != null) {
            aluno.setEndereco(endereco.convert());
        }
        return aluno;
    }

    public void setData(Aluno aluno) {
        super.setData(aluno);
        this.notas = convertToNotaDTOs(aluno.getNotas());
        this.cpf = aluno.getCpf();
        this.usuario = aluno.getUsuario();
        // this.senha = aluno.getSenha();
        if (aluno.getEndereco() != null) {
            EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setData(aluno.getEndereco());
            this.endereco = enderecoDTO;
        }

    }
}
