package br.edu.ufersa.sys_scholar.domain.repository;

import br.edu.ufersa.sys_scholar.domain.entity.Aluno;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    public Optional<Aluno> findByUsuario(String usuario);
}
