package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import br.edu.ufersa.sys_scholar.api.dto.DiretorDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Diretor;
import br.edu.ufersa.sys_scholar.domain.entity.Usuario;

@Mapper
public interface DiretorMapper {

    DiretorMapper INSTANCE = Mappers.getMapper(DiretorMapper.class);

    @Mapping(source = "usuario.value", target = "usuario")
    @Mapping(source = "codigo.id", target = "codigo")
    DiretorDTO diretorToDiretorDTO(Diretor diretor);

    @Mapping(source = "usuario", target = "usuario.value")
    @Mapping(source = "codigo", target = "codigo.id")
    Diretor diretorDTOToDiretor(DiretorDTO diretorDTO);

    List<DiretorDTO> diretoresToDiretorDTOs(List<Diretor> diretores);

    List<Diretor> diretorDTOsToDiretores(List<DiretorDTO> diretores);

    @Mapping(source = "usuario", target = "usuario.value")
    @Mapping(source = "codigo", target = "codigo.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiretorFromDiretorDTO(DiretorDTO diretorDTO, @MappingTarget Diretor diretor);

}
