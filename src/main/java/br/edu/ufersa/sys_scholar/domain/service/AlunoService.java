package br.edu.ufersa.sys_scholar.domain.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.exception.EntityNotExistsException;
import br.edu.ufersa.sys_scholar.api.exception.NullFieldsException;
import br.edu.ufersa.sys_scholar.api.exception.UserRegistredException;
import br.edu.ufersa.sys_scholar.api.mappers.AlunoMapper;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Usuario;
import br.edu.ufersa.sys_scholar.domain.repository.AlunoRepository;
import br.edu.ufersa.sys_scholar.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {
    // Get
    // Save
    // Update
    // Delete

    private AlunoRepository alunoRepository;
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<AlunoDTO> getAlunos() {
        final List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();

        return AlunoMapper.INSTANCE.alunosToAlunoDTOs(alunos);
    }

    public AlunoDTO getAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (!aluno.isPresent()) {
            throw new EntityNotExistsException("Aluno");
        }

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno.get());
    }

    public AlunoDTO getAlunoByUsuario(String value) {
        Optional<Usuario> usuario = usuarioRepository.findByValue(value);

        if (!usuario.isPresent()) {
            throw new EntityNotExistsException("Aluno");
        }

        Optional<Aluno> aluno = alunoRepository.findByUsuarioId(usuario.get().getId());

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno.get());
    }

    public AlunoDTO createAluno() {

        Aluno aluno = new Aluno();

        aluno.setEndereco(new Endereco();

        aluno.setCodigo(new Codigo());

        Aluno newAluno = alunoRepository.save(aluno);

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(newAluno);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoDTO updateAluno(AlunoDTO alunoDTO) {

        if (alunoDTO.getSenha() != null) {
            alunoDTO.setSenha(bCryptPasswordEncoder.encode(alunoDTO.getSenha()));
        }

        Aluno aluno = alunoRepository.findById(alunoDTO.getId()).get();

        AlunoMapper.INSTANCE.updateAlunoFromAlunoDTO(alunoDTO, aluno);

        alunoRepository.save(aluno);

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno);
    }

    public AlunoDTO registerAluno(AlunoDTO alunoDTO) {

        if (alunoDTO.getNome() == null ||
                alunoDTO.getCpf() == null ||
                alunoDTO.getUsuario() == null ||
                alunoDTO.getSenha() == null ||
                alunoDTO.getEndereco().getCidade() == null ||
                alunoDTO.getEndereco().getBairro() == null ||
                alunoDTO.getEndereco().getNumero() == null

        ) {
            throw new NullFieldsException();
        }

        if (alunoDTO.getSenha() != null) {
            alunoDTO.setSenha(bCryptPasswordEncoder.encode(alunoDTO.getSenha()));
        }

        Optional<Aluno> aluno = alunoRepository.findByCodigoId(alunoDTO.getCodigo());

        if (!aluno.isPresent()) {
            throw new EntityNotExistsException("Código de matrícula");
        }

        final Aluno alunoValidate = aluno.get();

        if (alunoValidate.getNome() != null ||
                alunoValidate.getCpf() != null ||
                alunoValidate.getUsuario() != null ||
                alunoValidate.getSenha() != null ||
                alunoValidate.getEndereco().getCidade() != null ||
                alunoValidate.getEndereco().getBairro() != null ||
                alunoValidate.getEndereco().getNumero() != null

        ) {
            throw new UserRegistredException();
        }

        AlunoMapper.INSTANCE.updateAlunoFromAlunoDTO(alunoDTO, aluno.get());

        Aluno newAluno = alunoRepository.save(aluno.get());

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(newAluno);
    }
}
