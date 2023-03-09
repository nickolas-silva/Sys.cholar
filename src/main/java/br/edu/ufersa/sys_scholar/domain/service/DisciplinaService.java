package br.edu.ufersa.sys_scholar.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.edu.ufersa.sys_scholar.domain.repository.AlunoRepository;
import br.edu.ufersa.sys_scholar.domain.repository.DisciplinaRepository;
import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import br.edu.ufersa.sys_scholar.api.dto.DisciplinaDTO;
import br.edu.ufersa.sys_scholar.api.dto.NotaDisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DisciplinaService {

    AlunoRepository alunoRepository;
    DisciplinaRepository disciplinaRepository;
    NotaRepository notaRepository;

    private DisciplinaDTO convertToDisciplinaDTO(Disciplina disciplina) {
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        disciplinaDTO.setData(disciplina);
        return disciplinaDTO;
    }

    private List<Nota> convertToNota(DisciplinaDTO disciplinaDTO) {
        List<Nota> listNotas = new ArrayList<>();
        Disciplina disciplina = disciplinaDTO.convert();
        disciplina.setNotas(null);
        for (NotaDisciplinaDTO notaDTO : disciplinaDTO.getNotas()) {
            Nota nota = notaDTO.convert();
            nota.setDisciplina(disciplina);
            listNotas.add(nota);
        }
        return listNotas;
    }

    public DisciplinaDTO getDisciplina(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isPresent()) {
            return convertToDisciplinaDTO(disciplina.get());
        }
        return null;
    }

    public List<DisciplinaDTO> getDisciplinas() {
        List<Disciplina> disciplinas = (List<Disciplina>) disciplinaRepository.findAll();
        List<DisciplinaDTO> disciplinaDTOs = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            disciplinaDTOs.add(convertToDisciplinaDTO(disciplina));
        }

        return disciplinaDTOs;
    }

    public DisciplinaDTO saveDisciplina(DisciplinaDTO disciplinaDTO) {
        if (disciplinaDTO.getId() != null) {
            // gerar execessão
        }
        Disciplina disciplina = disciplinaRepository.save(disciplinaDTO.convert());

        DisciplinaDTO disciplinaDTOSaved = new DisciplinaDTO();
        disciplinaDTOSaved.setData(disciplina);

        return disciplinaDTOSaved;
    }

    public void deleteDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public void atribuirAluno(Long idDisciplina, Long idAluno) {

        Optional<Aluno> aluno = alunoRepository.findById(idAluno);
        Optional<Disciplina> disciplina = disciplinaRepository.findById(idDisciplina);

        if (!(aluno.isPresent() && disciplina.isPresent())) {
            return;
        }
        Nota nota = new Nota();
        nota.setAluno(aluno.get());
        nota.setDisciplina(disciplina.get());
        notaRepository.save(nota);
    }

    public DisciplinaDTO updateDisciplina(DisciplinaDTO disciplinaDTO) {

        if (disciplinaDTO.getId() != null) {
            // gerar execessão
        }

        disciplinaRepository.save(disciplinaDTO.convert());

        if (disciplinaDTO.getNotas() == null) {
            return disciplinaDTO;
        }

        List<Nota> listNotas = convertToNota(disciplinaDTO);
        notaRepository.saveAll(listNotas);

        return disciplinaDTO;
    }
}
