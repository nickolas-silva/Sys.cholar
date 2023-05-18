package br.edu.ufersa.sys_scholar.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.api.exception.EntityNotExistsException;
import br.edu.ufersa.sys_scholar.api.exception.NullFieldsException;
import br.edu.ufersa.sys_scholar.api.exception.UserRegistredException;
import br.edu.ufersa.sys_scholar.api.mappers.AlunoMapper;
import br.edu.ufersa.sys_scholar.api.mappers.ProfessorMapper;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
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

  public ProfessorDTO getProfessorByCodigo(Long id) {
    Optional<Professor> professor = professorRepository.findByCodigoId(id);

    if (!professor.isPresent()) {
      throw new EntityNotExistsException("Professor");
    }

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(professor.get());
  }

  public ProfessorDTO createProfessor() {

    final Professor professor = new Professor();

    professor.setEndereco(new Endereco());

    professor.setCodigo(new Codigo());

    professor.setUsuario(new Usuario());

    final Professor newProfessor = professorRepository.save(professor);

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(newProfessor);
  }

  public void deleteProfessor(Long id) {
    professorRepository.deleteById(id);
  }

  public ProfessorDTO updateProfessor(final ProfessorDTO professorDTO) {
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
      throw new EntityNotExistsException("Professor");
    }

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(professor.get());
  }

  public ProfessorDTO getProfessorByUsuario(String value) {
    Optional<Usuario> usuario = usuarioRepository.findByValue(value);

    if (!usuario.isPresent()) {
      throw new EntityNotExistsException("Professor");
    }

    Optional<Professor> professor = professorRepository.findByUsuarioId(usuario.get().getId());

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(professor.get());
  }

  public ProfessorDTO registerProfessor(final ProfessorDTO professorDTO) {

    if (professorDTO.getNome() == null ||
        professorDTO.getCpf() == null ||
        professorDTO.getUsuario() == null ||
        professorDTO.getSenha() == null ||
        professorDTO.getEndereco().getCidade() == null ||
        professorDTO.getEndereco().getBairro() == null ||
        professorDTO.getEndereco().getNumero() == null

    ) {
      throw new NullFieldsException();
    }

    professorDTO.setSenha(bCryptPasswordEncoder.encode(professorDTO.getSenha()));

    final Optional<Professor> professor = professorRepository.findByCodigoId(professorDTO.getCodigo());

    if (!professor.isPresent()) {
      throw new EntityNotExistsException("Código de matrícula");
    }

    final Professor professorValidate = professor.get();

    if (professorValidate.getNome() != null ||
        professorValidate.getCpf() != null ||
        professorValidate.getUsuario().getValue() != null ||
        professorValidate.getSenha() != null ||
        professorValidate.getEndereco().getCidade() != null ||
        professorValidate.getEndereco().getBairro() != null ||
        professorValidate.getEndereco().getNumero() != null

    ) {
      throw new UserRegistredException();
    }

    ProfessorMapper.INSTANCE.updateProfessorFromProfessorDTO(professorDTO,
        professor.get());

    final Professor newProfessor = professorRepository.save(professor.get());

    return ProfessorMapper.INSTANCE.professorToProfessorDTO(newProfessor);
  }

}