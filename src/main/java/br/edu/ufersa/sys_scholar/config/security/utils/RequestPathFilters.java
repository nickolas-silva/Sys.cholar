package br.edu.ufersa.sys_scholar.config.security.utils;

import javax.servlet.http.HttpServletRequest;

import br.edu.ufersa.sys_scholar.api.dto.UserDTO;

public class RequestPathFilters {

    String path;
    UserDTO userDTO;
    String method;

    /**
     * @param request
     * @param userDTO
     */
    public RequestPathFilters(HttpServletRequest request, UserDTO userDTO) {
        this.path = request.getRequestURI();
        this.userDTO = userDTO;
        this.method = request.getMethod();
    }

    private Boolean isGET() {
        return this.method.equals("GET");
    }

    private Boolean isPathProfessor() {
        return this.path.startsWith("/professor") ||
                (this.isGET() && this.path.startsWith("/disciplina")) ||
                (this.path.startsWith("/disciplina/nota"));

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
