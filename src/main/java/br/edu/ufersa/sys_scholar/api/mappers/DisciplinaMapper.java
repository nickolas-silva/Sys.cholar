package br.edu.ufersa.sys_scholar.api.mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.DisciplinaDTO;
import br.edu.ufersa.sys_scholar.api.dto.NotaDisciplinaDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorToProfessorDTO")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaDisciplinaDTOs")
    DisciplinaDTO disciplinaToDisciplinaDTO(Disciplina disciplina);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorDTOToProfessor")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notaDisciplinaDTOsToNotas")
    Disciplina disciplinaDTOToDisciplina(DisciplinaDTO disciplinaDTO);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorToProfessorDTO")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaDisciplinaDTOs")
    List<DisciplinaDTO> disciplinasToDisciplinaDTOs(List<Disciplina> disciplinas);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorDTOToProfessor")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notaDisciplinaDTOsToNotas")
    List<Disciplina> disciplinaDTOsToDisciplinas(List<DisciplinaDTO> disciplinaDTOs);

    @Named("professorToProfessorDTO")
    public static ProfessorDTO professorToProfessorDTO(Professor professor) {
        return ProfessorMapper.INSTANCE.professorToProfessorDTO(professor);
    }

    @Named("professorDTOToProfessor")
    public static Professor professorDTOToProfessor(ProfessorDTO professorDTO) {
        return ProfessorMapper.INSTANCE.professorDTOToProfessor(professorDTO);
    }

    @Named("notasToNotaDisciplinaDTOs")
    public static List<NotaDisciplinaDTO> notaToNotaDTO(List<Nota> notas) {
        return NotaMapper.INSTANCE.NotasToNotaDisciplinaDTOs(notas);
    }

    @Named("notaDisciplinaDTOsToNotas")
    public static List<Nota> notaDTOsToNotas(List<NotaDisciplinaDTO> notasDisciplinaDTOs) {
        return NotaMapper.INSTANCE.NotaDisciplinaDTOsToNotas(notasDisciplinaDTOs);
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDisciplinaFromDisciplinaDTO(DisciplinaDTO disciplinaDTO, @MappingTarget Disciplina disciplina);

}
