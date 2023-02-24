package br.edu.ufersa.aipapaimacetei.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class updateUserDTO {
	@NotBlank(message="O email não pode ser null!!")
	@Email(message="O email deve ser um email!!")
	private String email;
	@NotBlank(message="A senha não pode ser null!!")
	@Size(min=5,max=20,message="a senha tem que ter entre 5 e 20 caracteres")
	private String Senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
}
