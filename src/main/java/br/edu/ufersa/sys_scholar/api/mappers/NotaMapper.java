package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import br.edu.ufersa.sys_scholar.api.dto.NotaDisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;

@Mapper
public interface NotaMapper {
    NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);

    @Mapping(source = "aluno.codigo", target = "aluno.codigo", qualifiedByName = "codigoToLong")
    List<NotaDisciplinaDTO> NotasToNotaDisciplinaDTOs(List<Nota> notas);

    @Mapping(source = "aluno.codigo", target = "aluno.codigo", qualifiedByName = "longToCodigo")
    List<Nota> NotaDisciplinaDTOsToNotas(List<NotaDisciplinaDTO> notaDTOs);

    @Mapping(source = "aluno.codigo", target = "aluno.codigo", qualifiedByName = "longToCodigo")
    Nota NotaDisciplinaDTOToNota(NotaDisciplinaDTO notaDisciplinaDTO);

    @Mapping(source = "aluno.codigo", target = "aluno.codigo", qualifiedByName = "codigoToLong")
    NotaDisciplinaDTO NotaToNotaDisciplinaDTO(Nota nota);

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

    // @Mapping(target = "aluno", ignore = true)
    // @Mapping(target = "disciplina", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNotaFromNota(Nota nota, @MappingTarget Nota notaTarget);

    // @Mapping(source = "endereco", target = "endereco", qualifiedByName =
    // "disciplinaDTOToNotas")
}
