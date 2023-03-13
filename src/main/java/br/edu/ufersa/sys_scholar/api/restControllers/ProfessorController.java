package br.edu.ufersa.sys_scholar.api.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

  // @PostMapping
  // public ResponseEntity<ProfessorDTO> saveProfessor(@RequestBody ProfessorDTO
  // professor) {
  // return new ResponseEntity<>(professorService.saveProfessor(professor),
  // HttpStatus.OK);
  // }

  @GetMapping("/{id}")
  public ResponseEntity<ProfessorDTO> getProfessor(@PathVariable Long id) {
    System.out.println(id);
    return new ResponseEntity<>(professorService.getProfessor(id),
        HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteProfessor(@PathVariable Long id) {
    professorService.deleteProfessor(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PatchMapping
  public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO professorDTO) {
    return new ResponseEntity<>(professorService.updateProfessor(professorDTO), HttpStatus.OK);
  }

}
