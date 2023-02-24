package br.edu.ufersa.aipapaimacetei.api.restControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.aipapaimacetei.Domain.userService;
import br.edu.ufersa.aipapaimacetei.Domain.entity.User;
import br.edu.ufersa.aipapaimacetei.api.dto.UserDTO;
import br.edu.ufersa.aipapaimacetei.api.dto.createUserDTO;
import br.edu.ufersa.aipapaimacetei.api.dto.updateUserDTO;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private userService service;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public List <UserDTO> listar(){
		List<UserDTO> users = new ArrayList<UserDTO>();
		for(User user: service.getAll()) {
			users.add(mapper.map(user,UserDTO.class));
		}
		return users;
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> buscar(@PathVariable UUID userId){
		UserDTO dto = mapper.map(service.getById(userId), UserDTO.class);
		if (dto!=null)
			return new ResponseEntity<>(dto, HttpStatus.OK);
		else return ResponseEntity.notFound().build();
	}	


	@PostMapping
	public ResponseEntity<UserDTO> criar(@Valid @RequestBody createUserDTO dto){
		User user = service.createUser(mapper.map(dto, User.class));
		UserDTO dto2 = mapper.map(user, UserDTO.class);
		if(user!=null) {
			return new ResponseEntity<>(dto2, HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@PutMapping
	public ResponseEntity<UserDTO> alterar(@Valid @RequestBody updateUserDTO dto){
		User user = service.updateUser(mapper.map(dto, User.class));
		UserDTO dto2 = mapper.map(user, UserDTO.class);
		if(dto2!=null) {
			return new ResponseEntity<>(dto2, HttpStatus.OK);
		}
		else return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@DeleteMapping("/{UserID}")
	public String deletar(@PathVariable UUID userID) {
		return "ok";
	}
	
	
}
