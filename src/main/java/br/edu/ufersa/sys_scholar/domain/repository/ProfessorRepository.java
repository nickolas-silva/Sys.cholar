package br.edu.ufersa.sys_scholar.domain.repository;

import br.edu.ufersa.sys_scholar.domain.entity.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository <Professor, Long> {
  
}
