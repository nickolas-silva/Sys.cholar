package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import br.edu.ufersa.sys_scholar.api.exception.InvalidCredencialsException;
import br.edu.ufersa.sys_scholar.api.exception.InvalidIdentifierException;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import br.edu.ufersa.sys_scholar.domain.service.ProfessorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {
  ProfessorService professorService;
  ProfessorRepository professorRepository;
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @RequestMapping(value = { "/{id}", "" }, method = RequestMethod.GET)
  public ResponseEntity<ProfessorDTO> getAluno(@PathVariable Optional<Long> id) {
    UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (userDTO.isDiretor()) {
      return new ResponseEntity<>(professorService.getProfessor(id.get()), HttpStatus.OK);

    }
    return new ResponseEntity<>(professorService.getProfessor(userDTO.getId()), HttpStatus.OK);

  }

  @RequestMapping(value = { "/{id}", "" }, method = RequestMethod.DELETE)
  public ResponseEntity<HttpStatus> deleteProfessor(@PathVariable Optional<Long> id,
      @RequestBody Optional<UserDTO> validateUserDTO) {
    final UserDTO contextUser = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (contextUser.isDiretor()) {
      professorService.deleteProfessor(id.get());
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    final ProfessorDTO currentProfessor = professorService.getProfessor(contextUser.getId());

    if (!validateUserDTO.isPresent() ||
        !bCryptPasswordEncoder.matches(validateUserDTO.get().getSenha(),
            currentProfessor.getSenha())) {
      throw new InvalidCredencialsException("Senha");
    }

    professorService.deleteProfessor(contextUser.getId());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PatchMapping
  public ResponseEntity<ProfessorDTO> updateAluno(@Valid @RequestBody ProfessorDTO professorDTO) {
    UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if ((professorDTO.getId() != userDTO.getId()) && (!userDTO.isDiretor())) {
      throw new InvalidIdentifierException();
    }

    return new ResponseEntity<>(professorService.updateProfessor(professorDTO), HttpStatus.OK);
  }

}
