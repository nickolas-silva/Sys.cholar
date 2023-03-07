package br.edu.ufersa.sys_scholar.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nota {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Double nota_01;
    private Double nota_02;
    private Double nota_03;
    private Double nota_04;
    private Double media;
    private Double exame_final;
    private Double media_final;


    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id")    
    private Disciplina disciplina;

}
