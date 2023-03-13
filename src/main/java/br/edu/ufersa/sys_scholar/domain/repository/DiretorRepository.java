package br.edu.ufersa.sys_scholar.domain.repository;

import br.edu.ufersa.sys_scholar.domain.entity.Diretor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DiretorRepository extends CrudRepository<Diretor, Long> {
    public Optional<Diretor> findByUsuarioId(Long usuario);
}
