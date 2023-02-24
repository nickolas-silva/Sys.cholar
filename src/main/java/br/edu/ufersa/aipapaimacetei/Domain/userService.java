package br.edu.ufersa.aipapaimacetei.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.stereotype.Service;

import br.edu.ufersa.aipapaimacetei.Domain.entity.User;
import br.edu.ufersa.aipapaimacetei.api.dto.UserDTO;
import br.edu.ufersa.aipapaimacetei.Domain.repository.userRepositoy;

@Service
public class userService {
	@Autowired
	private userRepositoy repository;
	
	public List <User> getAll(){
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setEmail("xerecaholmes@gmail.com");
		user1.setUuid(UUID.randomUUID());
		user1.setSenha("mengo");
		user1.setId(3);
		User user2 = new User();
		user2.setEmail("arimateia@gmail.com");
		user2.setUuid(UUID.randomUUID());
		user2.setSenha("vasco");
		user2.setId(24);
		users.add(user1);
		users.add(user2);
		return users;
	}
	
	public User getById(UUID id){
		User user1 = new User();
		user1.setEmail("encontrado@gmail.com");
		user1.setUuid(id);
		user1.setSenha("mengo");
		user1.setId(3);
		return user1;
	}
	
	public User createUser(User usu) {
		usu.setUuid(UUID.randomUUID());
		repository.save(usu);
		return usu;
	}
	
	public User updateUser(User user) {
		User dataUser = RepositoryType.findByUuid(user.getUuid());
		dataUser.setSenha(dataUser.getSenha());
		
		return user;
	}
	
	public User updateUserPatch(User user) {
		User dataUser = repository.findByEmail(user.getEmail());
		dataUser.setSenha(user.getSenha());
		
		return user;
		
	}
	
	public String deleteUser(User user) {
		return "ok";
	}
	
}
