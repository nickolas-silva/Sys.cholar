package br.edu.ufersa.sys_scholar.domain.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.edu.ufersa.sys_scholar.api.dto.DiretorDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Diretor;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Usuario;
import br.edu.ufersa.sys_scholar.domain.repository.DiretorRepository;
import br.edu.ufersa.sys_scholar.domain.repository.UsuarioRepository;
import br.edu.ufersa.sys_scholar.api.mappers.DiretorMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiretorService {

  private DiretorRepository diretorRepository;
  private UsuarioRepository usuarioRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public List<DiretorDTO> getDiretores() {
    List<Diretor> diretores = (List<Diretor>) diretorRepository.findAll();

    return DiretorMapper.INSTANCE.diretoresToDiretorDTOs(diretores);
  }

  public DiretorDTO getDiretor(Long id) {
    Diretor diretor = diretorRepository.findById(id).get();

    return DiretorMapper.INSTANCE.diretorToDiretorDTO(diretor);
  }

  public DiretorDTO getDiretorByUsuario(String value) {
    Optional<Usuario> usuario = usuarioRepository.findByValue(value);

    if (!usuario.isPresent()) {
      // Tratar
    }

    Optional<Diretor> diretor = diretorRepository.findByUsuarioId(usuario.get().getId());

    return DiretorMapper.INSTANCE.diretorToDiretorDTO(diretor.get());
  }

  public DiretorDTO createDiretor() {

    final Diretor diretor = new Diretor();

    diretor.setCodigo(new Codigo());

    final Diretor newDiretor = diretorRepository.save(diretor);

    return DiretorMapper.INSTANCE.diretorToDiretorDTO(newDiretor);
  }

  public DiretorDTO updateDiretor(DiretorDTO diretorDTO) {

    if (diretorDTO.getSenha() != null) {
      diretorDTO.setSenha(bCryptPasswordEncoder.encode(diretorDTO.getSenha()));
    }

    Diretor diretor = diretorRepository.findById(diretorDTO.getId()).get();

    DiretorMapper.INSTANCE.updateDiretorFromDiretorDTO(diretorDTO, diretor);

    Diretor diretorUptaded = diretorRepository.save(diretor);

    return DiretorMapper.INSTANCE.diretorToDiretorDTO(diretorUptaded);
  }

  public void deleteDiretor(Long id) {
    diretorRepository.deleteById(id);
  }

  public DiretorDTO registerAluno(DiretorDTO diretorDTO) {

    if (diretorDTO.getSenha() != null) {
      diretorDTO.setSenha(bCryptPasswordEncoder.encode(diretorDTO.getSenha()));
    }

    Optional<Diretor> diretor = diretorRepository.findByCodigoId(diretorDTO.getCodigo());

    if (!diretor.isPresent()) {
      // tratar
    }

    DiretorMapper.INSTANCE.updateDiretorFromDiretorDTO(diretorDTO, diretor.get());

    Diretor newDiretor = diretorRepository.save(diretor.get());

    return DiretorMapper.INSTANCE.diretorToDiretorDTO(newDiretor);
  }

}
