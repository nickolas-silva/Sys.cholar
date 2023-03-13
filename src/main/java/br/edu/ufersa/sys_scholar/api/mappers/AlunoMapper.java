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
import br.edu.ufersa.sys_scholar.api.dto.CodigoDTO;
import br.edu.ufersa.sys_scholar.api.dto.EnderecoDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Aluno;
import br.edu.ufersa.sys_scholar.domain.entity.Codigo;
import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import br.edu.ufersa.sys_scholar.domain.entity.Usuario;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    @Mapping(source = "usuario", target = "usuario", qualifiedByName = "usuarioToString")
    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "codigoToLong")
    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
    @Mapping(target = "notas", ignore = true)
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mapping(source = "usuario", target = "usuario", qualifiedByName = "stringToUsuario")
    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoDTOToEndereco")
    @Mapping(target = "notas", ignore = true)
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "codigoToLong")
    @Mapping(source = "endereco", target = "endereco", qualifiedByName = "enderecoToEnderecoDTO")
    @Mapping(target = "notas", ignore = true)
    List<AlunoDTO> alunosToAlunoDTOs(List<Aluno> alunos);

    // @Mapping(target = "notas", ignore = true)
    // @Mapping(target = "endereco", ignore = true)
    // Aluno AlunoDtoToAluno(AlunoDTO aluno);

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

    @Named("codigoToCodigoDTO")
    public static CodigoDTO codigoToCodigoDTO(Codigo codigo) {
        return CodigoMapper.INSTANCE.codigoToCodigoDTO(codigo);

        // return codigo.getId();
    }

    @Named("codigoDTOToCodigo")
    public static Codigo codigoDTOToCodigo(CodigoDTO codigoDTO) {
        // Codigo codigo = new Codigo();
        // return codigo;
        return CodigoMapper.INSTANCE.codigoDTOToCodigo(codigoDTO);
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
    @Mapping(source = "codigo", target = "codigo", qualifiedByName = "longToCodigo")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAlunoFromAlunoDTO(AlunoDTO alunoDTO, @MappingTarget Aluno aluno);

}
