package br.edu.ufersa.sys_scholar.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.edu.ufersa.sys_scholar.api.dto.DiretorDTO;
import br.edu.ufersa.sys_scholar.api.mappers.DiretorMapper;
import br.edu.ufersa.sys_scholar.domain.entity.Diretor;
//import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import br.edu.ufersa.sys_scholar.domain.repository.DiretorRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DiretorService {
  DiretorRepository diretorRepository;
  //NotaRepository notaRepository;

  public List<DiretorDTO> getProfessores(){
    final List<Diretor> diretores = (List<Diretor>) diretorRepository.findAll();
    List<DiretorDTO> diretoresDTO = new ArrayList<>();

    for  (Diretor diretor : diretores){
        DiretorDTO diretorDTO = new DiretorDTO();
      diretores.setData(diretor);
      diretoresDTO.add(diretorDTO);
    }

    return diretoresDTO;

  }

  public DiretorDTO saveDiretor(DiretorDTO diretorDTO){
    Diretor diretorzinho = diretorDTO.convert();
    Diretor newDiretorzinho = diretorRepository.save(diretorzinho);
    DiretorDTO newDiretorzinhoDTO = new DiretorDTO();
    newDiretorzinhoDTO.setData(newDiretorzinho);
    return newDiretorzinhoDTO;

  }

  public void deleteProfessor(Long id){
    diretorRepository.deleteById(id);
  }

  public DiretorDTO updateProfessor(DiretorDTO diretorDTO){
    
      Diretor diretor = diretorRepository.findById(diretorDTO.getId()).get();

      DiretorMapper.INSTANCE.updatediretorFromdiretorDTO(diretorDTO, diretor);

      Diretor diretorUptaded = diretorRepository.save(diretor);

      return DiretorMapper.INSTANCE.ProfessorTodiretorDTO(diretorUptaded);
  }

  public DiretorDTO getDiretor(Long id){
    Optional<Diretor> diretor = diretorRepository.findById(id);

    if(!diretor.isPresent()){
      //
    }

    DiretorDTO diretorDTO = new DiretorDTO();
    diretorDTO.setData(diretor.get());
    return diretorDTO;

  }
