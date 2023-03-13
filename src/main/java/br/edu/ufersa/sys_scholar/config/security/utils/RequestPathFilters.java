package br.edu.ufersa.sys_scholar.config.security.utils;

import br.edu.ufersa.sys_scholar.api.dto.UserDTO;

public class RequestPathFilters {

    String path;
    UserDTO userDTO;

    public RequestPathFilters(String path, UserDTO userDTO) {
        this.path = path;
        this.userDTO = userDTO;
    }

    private Boolean isPathProfessor() {
        return this.path.startsWith("/professor");
    }

    private Boolean isPathAluno() {
        return this.path.startsWith("/aluno");
    }

    // private Boolean isDiretor() {
    // return this.path.startsWith("/diretor");
    // }

    public Boolean isAuthorizedToPathAluno() {
        if (this.userDTO.isDiretor()) {
            return true;
        }
        return (this.isPathAluno() && this.userDTO.isAluno());
    }

    public Boolean isAuthorizedToPathProfessor() {
        if (this.userDTO.isDiretor()) {
            return true;
        }
        return (this.isPathProfessor() && this.userDTO.isProfessor());
    }
}
