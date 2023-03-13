package br.edu.ufersa.sys_scholar.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.api.mappers.ProfessorMapper;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {
  ProfessorRepository professorRepository;
  BCryptPasswordEncoder bCryptPasswordEncoder;
  // NotaRepository notaRepository;

  public List<ProfessorDTO> getProfessores() {
    final List<Professor> professores = (List<Professor>) professorRepository.findAll();
    List<ProfessorDTO> professorDTOs = ProfessorMapper.INSTANCE.professoresToProfessorDTOs(professores);

    return professorDTOs;

  }

  public ProfessorDTO saveProfessor(ProfessorDTO professorDTO) {

    if (professorDTO == null) {
      professorDTO = new ProfessorDTO();
    }

    Professor professor = ProfessorMapper.INSTANCE.professorDTOToProfessor(professorDTO);

    if (professor.getEndereco() == null) {
      professor.setEndereco(new Endereco());
    }
    professor.setCodigo(new Codigo());

    Professor newProfessor = professorRepository.save(professor);

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(newProfessor);

  }

  public void deleteProfessor(Long id) {
    professorRepository.deleteById(id);
  }

  public ProfessorDTO updateProfessor(ProfessorDTO professorDTO) {

    professorDTO.setSenha(bCryptPasswordEncoder.encode(professorDTO.getSenha()));

    Professor professor = professorRepository.findById(professorDTO.getId()).get();

    ProfessorMapper.INSTANCE.updateProfessorFromProfessorDTO(professorDTO, professor);

    Professor professorUpdated = professorRepository.save(professor);

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(professorUpdated);
  }

  public ProfessorDTO getProfessor(Long id) {
    Optional<Professor> professor = professorRepository.findById(id);

    if (!professor.isPresent()) {
      //
    }

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(professor.get());
  }
}