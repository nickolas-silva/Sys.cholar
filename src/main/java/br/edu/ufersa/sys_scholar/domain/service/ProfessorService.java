package br.edu.ufersa.sys_scholar.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.api.mappers.ProfessorMapper;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
//import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProfessorService {
  ProfessorRepository professorRepository;
  //NotaRepository notaRepository;

  public List<ProfessorDTO> getProfessores(){
    final List<Professor> professores = (List<Professor>) professorRepository.findAll();
    List<ProfessorDTO> professorDTOs = new ArrayList<>();

    for  (Professor professor : professores){
      ProfessorDTO professorDTO = new ProfessorDTO();
      professorDTO.setData(professor);
      professorDTOs.add(professorDTO);
    }

    return professorDTOs;

  }

  public ProfessorDTO saveProfessor(ProfessorDTO professorDTO){
    Professor prof = professorDTO.convert();
    Professor newProf = professorRepository.save(prof);
    ProfessorDTO newProfDTO = new ProfessorDTO();
    newProfDTO.setData(newProf);
    return newProfDTO;

  }

  public void deleteProfessor(Long id){
    professorRepository.deleteById(id);
  }

  public ProfessorDTO updateProfessor(ProfessorDTO professorDTO){
    
      Professor professor = professorRepository.findById(professorDTO.getId()).get();

      ProfessorMapper.INSTANCE.updateProfessorFromProfessorDTO(professorDTO, professor);

      professorRepository.save(professor);

      return ProfessorMapper.INSTANCE.ProfessorToAlunoDTO(professor);
  }

  public ProfessorDTO getProfessor(Long id){
    Optional<Professor> professor = professorRepository.findById(id);

    if(!professor.isPresent()){
      //
    }

    ProfessorDTO professorDTO = new ProfessorDTO();
    professorDTO.setData(professor.get());
    return professorDTO;

  }
}