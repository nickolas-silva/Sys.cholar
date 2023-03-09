package br.edu.ufersa.sys_scholar.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
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

    AlunoRepository alunoRepository;
    NotaRepository notaRepository;

    public List<AlunoDTO> getAlunos() {
        final List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();
        List<AlunoDTO> alunoDTOs = new ArrayList<>();

        for (Aluno aluno : alunos) {
            AlunoDTO alunoDTO = new AlunoDTO();
            alunoDTO.setData(aluno);
            alunoDTOs.add(alunoDTO);
        }

        return alunoDTOs;
    }

    public AlunoDTO getAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (!aluno.isPresent()) {
            // Tratar
        }

        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setData(aluno.get());

        return alunoDTO;
    }

    public AlunoDTO saveAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.save(alunoDTO.convert());

        AlunoDTO newAlunoDTO = new AlunoDTO();
        newAlunoDTO.setData(aluno);

        return newAlunoDTO;
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoDTO updateAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.save(alunoDTO.convert());

        AlunoDTO updatedAlunoDTO = new AlunoDTO();
        updatedAlunoDTO.setData(aluno);

        return updatedAlunoDTO;
    }
}
