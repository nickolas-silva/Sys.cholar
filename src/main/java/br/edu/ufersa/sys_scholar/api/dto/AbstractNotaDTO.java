package br.edu.ufersa.sys_scholar.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNotaDTO {

    protected Long id;
    protected Double nota01;
    protected Double nota02;
    protected Double nota03;
    protected Double nota04;
    protected Double media;
    protected Double exameFinal;
    protected Double mediaFinal;

}
