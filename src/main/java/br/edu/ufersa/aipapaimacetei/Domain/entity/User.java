package br.edu.ufersa.aipapaimacetei.Domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
@Entity
@Table(name = "tb_user")
public class User {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(unique=true, nullable=false)
	private String email;
	private UUID uuid;
	private String Senha;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
	
}