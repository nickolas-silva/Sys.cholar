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

@Mapper
public interface DiretorMapper {

    DiretorMapper INSTANCE = Mappers.getMapper(DiretorMapper.class);

    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "codigoToLong")
    DiretorDTO diretorToDiretorDTO(Diretor diretor);

    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
    Diretor diretorDTOToDiretor(DiretorDTO diretorDTO);

    List<DiretorDTO> diretoresToDiretorDTOs(List<Diretor> diretores);

    List<Diretor> diretorDTOsToDiretores(List<DiretorDTO> diretores);

    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiretorFromDiretorDTO(DiretorDTO diretorDTO, @MappingTarget Diretor diretor);

    @Named("codigoToLong")
    public static Long codigoToLong(Codigo codigo) {
        return codigo.getId();
    }

    @Named("longToCodigo")
    public static Codigo LongToCodigo(Long codigo) {
        Codigo newCodigo = new Codigo();
        newCodigo.setId(codigo);
        return newCodigo;
    }

}
