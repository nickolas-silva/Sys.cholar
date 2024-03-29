package br.edu.ufersa.sys_scholar.api.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.EnderecoDTO;
import br.edu.ufersa.sys_scholar.api.dto.NotaAlunoDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    @Mapping(source = "usuario.value", target = "usuario")
    @Mapping(source = "codigo.id", target = "codigo")
    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaAlunoDTOs")
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mapping(source = "usuario", target = "usuario.value")
    @Mapping(source = "codigo", target = "codigo.id")
    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
    @Mapping(target = "notas", ignore = true)
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "codigoToLong")
    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
    @Mapping(source = "notas", target = "notas", qualifiedByName = "notasToNotaAlunoDTOs")
    List<AlunoDTO> alunosToAlunoDTOs(List<Aluno> alunos);

    // @Mapping(target = "notas", ignore = true)
    // @Mapping(target = "endereco", ignore = true)
    // Aluno AlunoDtoToAluno(AlunoDTO aluno);

    @Named("notasToNotaAlunoDTOs")
    public static List<NotaAlunoDTO> notasToNotaAlunoDTOs(List<Nota> notas) {
        return NotaMapper.INSTANCE.NotasToNotaAlunoDTOs(notas);
    }

    @Named("notaToNotaAlunoDTO")
    public static NotaAlunoDTO notaToNotaAlunoDTO(Nota nota) {
        return NotaMapper.INSTANCE.NotaToNotaAlunoDTO(nota);
    }

    @Named("enderecoToEnderecoDTO")
    public static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        return EnderecoMapper.INSTANCE.EnderecoToEnderecoDTO(endereco);
    }

    @Named("enderecoDTOToEndereco")
    public static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        return EnderecoMapper.INSTANCE.EnderecoDTOToEndereco(enderecoDTO);
    }

    @Mapping(source = "usuario", target = "usuario.value")
    @Mapping(target = "notas", ignore = true)
    @Mapping(source = "codigo", target = "codigo.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAlunoFromAlunoDTO(AlunoDTO alunoDTO, @MappingTarget Aluno aluno);

}
