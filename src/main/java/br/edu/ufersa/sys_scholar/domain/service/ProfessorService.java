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
import br.edu.ufersa.sys_scholar.domain.entity.Usuario;
import br.edu.ufersa.sys_scholar.domain.repository.ProfessorRepository;
import br.edu.ufersa.sys_scholar.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {
  private ProfessorRepository professorRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  private UsuarioRepository usuarioRepository;

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
    if (professorDTO.getSenha() != null) {
      professorDTO.setSenha(bCryptPasswordEncoder.encode(professorDTO.getSenha()));
    }
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

  public ProfessorDTO getProfessorByUsuario(String value) {
    Optional<Usuario> usuario = usuarioRepository.findByValue(value);

    if (!usuario.isPresent()) {
      // Tratar
    }

    Optional<Professor> aluno = professorRepository.findByUsuarioId(usuario.get().getId());

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(aluno.get());
  }

  public ProfessorDTO registerProfessor(ProfessorDTO professorDTO) {

    if (professorDTO.getSenha() != null) {
      professorDTO.setSenha(bCryptPasswordEncoder.encode(professorDTO.getSenha()));
    }

    Optional<Professor> professor = professorRepository.findByCodigoId(professorDTO.getCodigo());

    ProfessorMapper.INSTANCE.updateProfessorFromProfessorDTO(professorDTO, professor.get());

    Professor newProfessor = professorRepository.save(professor.get());

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(newProfessor);
  }
}