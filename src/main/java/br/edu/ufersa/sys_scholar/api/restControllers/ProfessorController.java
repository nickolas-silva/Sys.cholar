package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import br.edu.ufersa.sys_scholar.domain.service.ProfessorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {
  ProfessorService professorService;
  ProfessorRepository professorRepository;

  @GetMapping
  public ResponseEntity<List<ProfessorDTO>> getProfessores(){
    return new ResponseEntity<>(professorService.getProfessor(), HttpStatus.OK);
  }
}
