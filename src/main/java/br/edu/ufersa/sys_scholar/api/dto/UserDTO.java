package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String usuario;
    private String senha;
    private String role;
    private Long id;

    public Boolean isDiretor() {
        return this.role.equals("diretor");
    }

    public Boolean isProfessor() {
        return this.role.equals("professor");
    }

    public Boolean isAluno() {
        return this.role.equals("aluno");
    }
}
