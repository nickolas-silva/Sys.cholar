package br.edu.ufersa.sys_scholar.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Diretor;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
import br.edu.ufersa.sys_scholar.domain.repository.AlunoRepository;
import br.edu.ufersa.sys_scholar.domain.repository.DiretorRepository;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {
    AlunoRepository alunoRepository;
    ProfessorRepository professorRepository;
    DiretorRepository diretorRepository;

    private UserDTO createUserDTO(String usuario, String senha, String role) {
        UserDTO userDTO = new UserDTO();
        userDTO.setSenha(senha);
        userDTO.setUsuario(usuario);
        userDTO.setRole(role);
        return userDTO;
    }

    public UserDTO findByUsuario(String usuario) {

        Optional<Diretor> diretor = diretorRepository.findByUsuario(usuario);

        if (diretor.isPresent()) {
            Diretor findDiretor = diretor.get();
            return createUserDTO(findDiretor.getUsuario().getValue(), findDiretor.getSenha(), "diretor");
        }

        Optional<Professor> professor = professorRepository.findByUsuario(usuario);

        if (professor.isPresent()) {
            Professor findProfessor = professor.get();
            return createUserDTO(findProfessor.getUsuario().getValue(), findProfessor.getSenha(), "professor");
        }

        Optional<Aluno> aluno = alunoRepository.findByUsuario(usuario);

        if (aluno.isPresent()) {
            Aluno findAluno = aluno.get();
            return createUserDTO(findAluno.getUsuario().getValue(), findAluno.getSenha(), "aluno");
        }

        return null;
    }
}
