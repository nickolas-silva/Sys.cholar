package br.edu.ufersa.sys_scholar.domain.repository;

import br.edu.ufersa.sys_scholar.domain.entity.Professor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    public Optional<Professor> findByUsuarioId(Long usuario);

    public Optional<Professor> findByCodigoId(Long codigo);

}
