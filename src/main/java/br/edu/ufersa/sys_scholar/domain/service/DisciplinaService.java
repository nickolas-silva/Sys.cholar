package br.edu.ufersa.sys_scholar.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufersa.sys_scholar.domain.repository.DisciplinaRepository;
import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import br.edu.ufersa.sys_scholar.api.dto.DisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DisciplinaService {
    
    DisciplinaRepository disciplinaRepository;
    NotaRepository notaRepository;
 
    private DisciplinaDTO convertToDisciplinaDTO (Disciplina disciplina){
        List<Nota> notas = notaRepository.findByDisciplinaId(disciplina.getId());
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        disciplinaDTO.getData(disciplina);
        disciplinaDTO.setNotas(notas);
        return disciplinaDTO;
    } 

    public DisciplinaDTO getDisciplina(Long id){
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if(disciplina.isPresent()){
            return convertToDisciplinaDTO(disciplina.get());
        }
        return null;
    }

    public List<DisciplinaDTO> getDisciplinas(){
        List<Disciplina> disciplinas = (List<Disciplina>)disciplinaRepository.findAll();
        List<DisciplinaDTO> disciplinaDTOs = new ArrayList<>();

        for(Disciplina disciplina : disciplinas){
            disciplinaDTOs.add(convertToDisciplinaDTO(disciplina));
        }

        return disciplinaDTOs;
    }
    public DisciplinaDTO saveDisciplina(DisciplinaDTO disciplinaDTO){
        Disciplina disciplina = disciplinaRepository.save(disciplinaDTO.convert());
        if(disciplina == null){
            return null;
        }
        DisciplinaDTO disciplinaDTOSaved = new DisciplinaDTO();
        disciplinaDTOSaved.getData(disciplina);
        return disciplinaDTOSaved;
    } 

    public void deleteDisciplina(Long id){
        disciplinaRepository.deleteById(id);
    }
}
