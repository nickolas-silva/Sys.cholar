package br.edu.ufersa.sys_scholar.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufersa.sys_scholar.domain.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public Optional<Usuario> findByValue(String value);

}
