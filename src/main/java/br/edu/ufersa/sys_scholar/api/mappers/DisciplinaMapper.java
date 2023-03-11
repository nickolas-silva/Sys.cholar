package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.DisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    // @Mapping(source = "notas", target = "notas", qualifiedByName =
    // "notasToNotaDisciplinaDTOs")
    DisciplinaDTO DisciplinaToDisciplinaDTO(Disciplina disciplina);

    // @Mapping(source = "notas", target = "notas", qualifiedByName =
    // "notaDisciplinaDTOsToNotas")
    Disciplina DisciplinaDTOToDisciplina(DisciplinaDTO disciplinaDTO);

    // @Named("notasToNotaDisciplinaDTOs")
    // public static List<NotaDisciplinaDTO> notaToNotaDTO(List<Nota> notas) {
    // return NotaMapper.INSTANCE.NotasToNotaDisciplinaDTOs(notas);
    // }

    // @Named("notaDisciplinaDTOsToNotas")
    // public static List<Nota> NotaDTOsToNotas(List<NotaDisciplinaDTO>
    // notasDisciplinaDTOs) {
    // return null;
    // // return NotaMapper.INSTANCE.NotaDisciplinaDTOsToNotas(notasDisciplinaDTOs);
    // }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDisciplinaFromDisciplinaDTO(DisciplinaDTO disciplinaDTO, @MappingTarget Disciplina disciplina);

}
