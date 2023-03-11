package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.EnderecoDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
    @Mapping(target = "notas", ignore = true)
    AlunoDTO AlunoToAlunoDTO(Aluno aluno);

    // @Mapping(target = "notas", ignore = true)
    // @Mapping(target = "endereco", ignore = true)
    // Aluno AlunoDtoToAluno(AlunoDTO aluno);

    @Named("enderecoToEnderecoDTO")
    public static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setData(endereco);

        return enderecoDTO;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAlunoFromAlunoDTO(AlunoDTO alunoDTO, @MappingTarget Aluno aluno);

}
