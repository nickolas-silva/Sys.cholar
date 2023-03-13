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

  @Mapping(source = "usuario", target = "usuario", qualifiedByName = "usuarioToString")
  @Mapping(source = "codigo", target = "codigo", qualifiedByName = "codigoToLong")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
  @Mapping(source = "disciplinas", target = "disciplinas", qualifiedByName = "disciplinasToDisciplinaProfessorDTOs")
  ProfessorDTO professorToProfessorDTO(Professor professor);

  @Mapping(source = "usuario", target = "usuario", qualifiedByName = "stringToUsuario")
  @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
  @Mapping(source = "disciplinas", target = "disciplinas", qualifiedByName = "disciplinaProfessorDTOsToDisciplinas")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
  Professor professorDTOToProfessor(ProfessorDTO professorDTO);

  @Mapping(source = "usuario", target = "usuario", qualifiedByName = "usuarioToString")
  @Mapping(source = "codigo", target = "codigo", qualifiedByName = "codigoToLong")
  @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
  ProfessorDisciplinaDTO professorToProfessorDisciplinaDTO(Professor professor);

  @Mapping(source = "usuario", target = "usuario", qualifiedByName = "stringToUsuario")
  @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
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

  @Named("usuarioToString")
  public static String codigoToLong(Usuario usuario) {
    return usuario.getValue();
  }

  @Named("stringToUsuario")
  public static Usuario codigoToLong(String usuario) {
    Usuario user = new Usuario();
    user.setValue(usuario);
    return user;
  }

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

  // @Mapping(source = "usuario", target = "usuario", qualifiedByName =
  // "stringToUsuario")
  @Mapping(source = "usuario", target = "usuario.value")
  @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateProfessorFromProfessorDTO(ProfessorDTO professorDTO, @MappingTarget Professor professor);

}
