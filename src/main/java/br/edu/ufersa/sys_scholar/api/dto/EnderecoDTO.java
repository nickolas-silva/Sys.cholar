package br.edu.ufersa.sys_scholar.api.dto;

import br.edu.ufersa.sys_scholar.domain.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO implements InterfaceDTO<Endereco>{
    
    private Long id;
    private String cidade;
    private String bairro;
    private Integer numero;

    @Override
    public Endereco convert() {
        Endereco endereco = new Endereco();
        endereco.setId(id);
        endereco.setCidade(cidade);;
        endereco.setBairro(bairro);
        endereco.setNumero(numero);

        return endereco;
    }

    @Override
    public void getData(Endereco endereco) {
        this.id = endereco.getId();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.numero = endereco.getNumero();
    }
}