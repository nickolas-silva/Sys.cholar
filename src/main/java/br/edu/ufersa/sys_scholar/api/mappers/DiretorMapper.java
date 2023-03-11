package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import br.edu.ufersa.sys_scholar.api.dto.DiretorDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Diretor;

@Mapper
public interface DiretorMapper {

    DiretorMapper INSTANCE = Mappers.getMapper(DiretorMapper.class);

    DiretorDTO diretorToDiretorDTO(Diretor diretor);

    Diretor diretorDTOToDiretor(DiretorDTO diretorDTO);

    List<DiretorDTO> diretoresToDiretorDTOs(List<Diretor> diretores);

    List<Diretor> diretorDTOsToDiretores(List<DiretorDTO> diretores);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiretorFromDiretorDTO(DiretorDTO diretorDTO, @MappingTarget Diretor diretor);

}
