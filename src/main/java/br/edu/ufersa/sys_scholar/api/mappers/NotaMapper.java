package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import br.edu.ufersa.sys_scholar.api.dto.NotaDisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;

@Mapper
public interface NotaMapper {
    NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);

    List<NotaDisciplinaDTO> NotasToNotaDisciplinaDTOs(List<Nota> notas);

    List<Nota> NotaDisciplinaDTOsToNotas(List<NotaDisciplinaDTO> notaDTOs);

    Nota NotaDisciplinaDTOToNota(NotaDisciplinaDTO notaDisciplinaDTO);

    NotaDisciplinaDTO NotaToNotaDisciplinaDTO(Nota nota);

    // @Mapping(target = "aluno", ignore = true)
    // @Mapping(target = "disciplina", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNotaFromNota(Nota nota, @MappingTarget Nota notaTarget);

    // @Mapping(source = "endereco", target = "endereco", qualifiedByName =
    // "disciplinaDTOToNotas")
}
