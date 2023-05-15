package br.edu.ufersa.sys_scholar.api.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.NotaAlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.NotaDisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;

@Mapper
public interface NotaMapper {
    NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);

    @Mapping(source = "aluno.codigo.id", target = "aluno.codigo")
    List<NotaDisciplinaDTO> NotasToNotaDisciplinaDTOs(List<Nota> notas);

    @Mapping(source = "aluno.codigo", target = "aluno.codigo.id")
    List<Nota> NotaDisciplinaDTOsToNotas(List<NotaDisciplinaDTO> notaDTOs);

    @Mapping(source = "aluno.codigo", target = "aluno.codigo.id")
    Nota NotaDisciplinaDTOToNota(NotaDisciplinaDTO notaDisciplinaDTO);

    @Mapping(source = "aluno.codigo.id", target = "aluno.codigo")
    NotaDisciplinaDTO NotaToNotaDisciplinaDTO(Nota nota);

    @Mapping(source = "disciplina.professor.codigo.id", target = "disciplina.professor.codigo")
    @Mapping(source = "disciplina.professor.usuario.value", target = "disciplina.professor.usuario")
    NotaAlunoDTO NotaToNotaAlunoDTO(Nota nota);

    List<NotaAlunoDTO> NotasToNotaAlunoDTOs(List<Nota> notas);

    // @Mapping(target = "aluno", ignore = true)
    // @Mapping(target = "disciplina", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNotaFromNota(Nota nota, @MappingTarget Nota notaTarget);

    // @Mapping(source = "endereco", target = "endereco", qualifiedByName =
    // "disciplinaDTOToNotas")
}
