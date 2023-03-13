package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.CodigoDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;

@Mapper
public interface CodigoMapper {
    CodigoMapper INSTANCE = Mappers.getMapper(CodigoMapper.class);

    Codigo codigoDTOToCodigo(CodigoDTO codigoDTO);

    CodigoDTO codigoToCodigoDTO(Codigo codigo);
}
