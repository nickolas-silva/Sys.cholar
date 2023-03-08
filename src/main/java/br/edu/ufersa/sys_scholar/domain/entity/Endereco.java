package br.edu.ufersa.sys_scholar.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String cidade;
    @NonNull
    private String bairro;
    @NonNull
    private Integer numero;
    
}
