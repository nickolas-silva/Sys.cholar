package br.edu.ufersa.sys_scholar.domain.repository;

import br.edu.ufersa.sys_scholar.domain.entity.Nota;

import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface NotaRepository extends CrudRepository<Nota, Long> {
    public List<Nota> findByDisciplinaId(Long disciplinaId);
}

