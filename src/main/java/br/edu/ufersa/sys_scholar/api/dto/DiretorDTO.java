package br.edu.ufersa.sys_scholar.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufersa.sys_scholar.domain.entity.Diretor;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiretorDTO implements InterfaceDTO<Diretor> {

    protected Integer cpf;
    protected String usuario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String senha;

    public Diretor convert() {
        Diretor diretor = new Diretor();
        diretor.setCpf(this.cpf);
        diretor.setSenha(this.senha);
        diretor.setUsuario(this.usuario);
        return diretor;
    }

    public void setData(Diretor diretor) {
        this.cpf = diretor.getCpf();
        this.usuario = diretor.getUsuario();
        // this.senha = diretor.getSenha();
    }
}
