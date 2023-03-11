package br.edu.ufersa.sys_scholar.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import br.edu.ufersa.sys_scholar.api.dto.EnderecoDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;

@Mapper
public interface ProfessorMapper {
  ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
  ProfessorDTO ProfessorToprofessorDTO(Professor professor);

  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
  Professor professorDTOToProfessor(ProfessorDTO professorDTO);

  @Named("enderecoToEnderecoDTO")
  public static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
    EnderecoDTO enderecoDTO = new EnderecoDTO();
    enderecoDTO.setData(endereco);

    return enderecoDTO;
  }

  @Named("enderecoDTOToEndereco")
  public static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
    Endereco endereco = enderecoDTO.convert();

    return endereco;
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateProfessorFromProfessorDTO(ProfessorDTO professorDTO, @MappingTarget Professor professor);

}
