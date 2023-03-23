package br.edu.ufersa.sys_scholar.api.mappers;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.edu.ufersa.sys_scholar.api.dto.DisciplinaProfessorDTO;
import br.edu.ufersa.sys_scholar.api.dto.EnderecoDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDisciplinaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Professor;
import br.edu.ufersa.sys_scholar.domain.entity.Usuario;

@Mapper
public interface ProfessorMapper {
  ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

  @Mapping(source = "usuario.value", target = "usuario")
  @Mapping(source = "codigo.id", target = "codigo")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
  @Mapping(source = "disciplinas", target = "disciplinas", qualifiedByName = "disciplinasToDisciplinaProfessorDTOs")
  ProfessorDTO professorToProfessorDTO(Professor professor);

  @Mapping(source = "usuario", target = "usuario.value")
  @Mapping(source = "codigo", target = "codigo.id")
  @Mapping(source = "disciplinas", target = "disciplinas", qualifiedByName = "disciplinaProfessorDTOsToDisciplinas")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
  Professor professorDTOToProfessor(ProfessorDTO professorDTO);

  @Mapping(source = "usuario.value", target = "usuario")
  @Mapping(source = "codigo.id", target = "codigo")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
  ProfessorDisciplinaDTO professorToProfessorDisciplinaDTO(Professor professor);

  @Mapping(source = "usuario", target = "usuario.value")
  @Mapping(source = "codigo", target = "codigo.id")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
  Professor professorDisciplinaDTOToProfessor(ProfessorDisciplinaDTO professorDisciplinaDTO);

  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
  List<ProfessorDTO> professoresToProfessorDTOs(List<Professor> professorDTOs);

  @Named("enderecoToEnderecoDTO")
  public static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {

    return EnderecoMapper.INSTANCE.EnderecoToEnderecoDTO(endereco);
  }

  @Named("enderecoDTOToEndereco")
  public static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {

    return EnderecoMapper.INSTANCE.EnderecoDTOToEndereco(enderecoDTO);
  }

  @Named("disciplinasToDisciplinaProfessorDTOs")
  public static List<DisciplinaProfessorDTO> disciplinaToDisciplinaProfessorDTO(List<Disciplina> disciplinas) {

    return DisciplinaMapper.INSTANCE.disciplinasToDisciplinaProfessorDTOs(disciplinas);
  }

  @Named("disciplinaProfessorDTOsToDisciplinas")
  public static List<Disciplina> enderecoDTOToEndereco(List<DisciplinaProfessorDTO> disciplinaProfessorDTOs) {

    return DisciplinaMapper.INSTANCE.disciplinaProfessorDTOsToDisciplinas(disciplinaProfessorDTOs);
  }

  // @Mapping(source = "usuario", target = "usuario", qualifiedByName =
  // "stringToUsuario")
  @Mapping(source = "usuario", target = "usuario.value")
  @Mapping(source = "codigo", target = "codigo.id")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateProfessorFromProfessorDTO(ProfessorDTO professorDTO, @MappingTarget Professor professor);

}
