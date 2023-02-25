package br.edu.ufersa.aipapaimacetei.Domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.aipapaimacetei.Domain.entity.User;

public interface userRepositoy extends JpaRepository<User, Long>{
	User findByUuid(UUID uuid);
	User findByEmail(String email);
}
