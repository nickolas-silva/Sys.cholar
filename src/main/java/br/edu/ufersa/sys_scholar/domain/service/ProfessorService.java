package br.edu.ufersa.sys_scholar.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
//import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {
  ProfessorRepository professorRepository;
  //NotaRepository notaRepository;

  public List<ProfessorDTO> getProfessor(){
    final List<Professor> professores = (List<Professor>) professorRepository.findAll();
    List<ProfessorDTO> professorDTOs = new ArrayList<>();

    for  (Professor professor : professores){
      ProfessorDTO professorDTO = new ProfessorDTO();
      professorDTO.setData(professor);
      professorDTOs.add(professorDTO);
    }

    return professorDTOs;

  }

}
