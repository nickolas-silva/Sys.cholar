package br.edu.ufersa.sys_scholar.api.mappers;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.DisciplinaDTO;
import br.edu.ufersa.sys_scholar.api.dto.DisciplinaProfessorDTO;
import br.edu.ufersa.sys_scholar.api.dto.NotaDisciplinaDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorToProfessorDisciplinaDTO")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaDisciplinaDTOs")
    DisciplinaDTO disciplinaToDisciplinaDTO(Disciplina disciplina);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorDisciplinaDTOToProfessor")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notaDisciplinaDTOsToNotas")
    Disciplina disciplinaDTOToDisciplina(DisciplinaDTO disciplinaDTO);

    // DisciplinaProfessorDTO

    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaDisciplinaDTOs")
    List<DisciplinaProfessorDTO> disciplinasToDisciplinaProfessorDTOs(List<Disciplina> disciplinas);

    @Mapping(source = "notas", target = "notas", qualifiedByName = "notaDisciplinaDTOsToNotas")
    List<Disciplina> disciplinaProfessorDTOsToDisciplinas(List<DisciplinaProfessorDTO> disciplinaProfessorDTOs);

    /////////

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorToProfessorDisciplinaDTO")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaDisciplinaDTOs")
    List<DisciplinaDTO> disciplinasToDisciplinaDTOs(List<Disciplina> disciplinas);

    @Mapping(source = "professor", target = "professor", qualifiedByName = "professorDisciplinaDTOToProfessor")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notaDisciplinaDTOsToNotas")
    List<Disciplina> disciplinaDTOsToDisciplinas(List<DisciplinaDTO> disciplinaDTOs);

    @Named("professorToProfessorDisciplinaDTO")
    public static ProfessorDisciplinaDTO professorToProfessorDTO(Professor professor) {
        return ProfessorMapper.INSTANCE.professorToProfessorDisciplinaDTO(professor);
    }

    @Named("professorDisciplinaDTOToProfessor")
    public static Professor professorDTOToProfessor(ProfessorDisciplinaDTO professorDisciplinaDTO) {
        return ProfessorMapper.INSTANCE.professorDisciplinaDTOToProfessor(professorDisciplinaDTO);
    }

    @Named("notasToNotaDisciplinaDTOs")
    public static List<NotaDisciplinaDTO> notaToNotaDTO(List<Nota> notas) {
        return NotaMapper.INSTANCE.NotasToNotaDisciplinaDTOs(notas);
    }

    @Named("notaDisciplinaDTOsToNotas")
    public static List<Nota> notaDTOsToNotas(List<NotaDisciplinaDTO> notasDisciplinaDTOs) {
        return NotaMapper.INSTANCE.NotaDisciplinaDTOsToNotas(notasDisciplinaDTOs);
    }

    @Mapping(source = "professor.codigo", target = "professor.codigo", qualifiedByName = "longToCodigo")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notaDisciplinaDTOsToNotas")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDisciplinaFromDisciplinaDTO(DisciplinaDTO disciplinaDTO, @MappingTarget Disciplina disciplina);

    @Named("longToCodigo")
    public static Codigo LongToCodigo(Long codigo) {
        Codigo newCodigo = new Codigo();
        newCodigo.setId(codigo);
        return newCodigo;
    }

}
