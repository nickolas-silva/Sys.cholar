package br.edu.ufersa.sys_scholar.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.mappers.AlunoMapper;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.repository.AlunoRepository;
import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {
    // Get
    // Save
    // Update
    // Delete

    private AlunoRepository alunoRepository;
    private NotaRepository notaRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<AlunoDTO> getAlunos() {
        final List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();

        return AlunoMapper.INSTANCE.alunosToAlunoDTOs(alunos);
    }

    public AlunoDTO getAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (!aluno.isPresent()) {
            // Tratar
        }

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno.get());
    }

    public AlunoDTO saveAluno(AlunoDTO alunoDTO) {

        if (alunoDTO == null) {
            alunoDTO = new AlunoDTO();
        }

        Aluno aluno = AlunoMapper.INSTANCE.alunoDTOToAluno(alunoDTO);

        if (aluno.getEndereco() == null) {
            aluno.setEndereco(new Endereco());
        }

        aluno.setCodigo(new Codigo());

        Aluno newAluno = alunoRepository.save(aluno);

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(newAluno);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoDTO updateAluno(AlunoDTO alunoDTO) {

        alunoDTO.setSenha(bCryptPasswordEncoder.encode(alunoDTO.getSenha()));

        Aluno aluno = alunoRepository.findById(alunoDTO.getId()).get();

        AlunoMapper.INSTANCE.updateAlunoFromAlunoDTO(alunoDTO, aluno);

        alunoRepository.save(aluno);

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno);
    }
}
