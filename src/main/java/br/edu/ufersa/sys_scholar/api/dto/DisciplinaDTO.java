package br.edu.ufersa.sys_scholar.api.dto;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;

import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DisciplinaDTO implements InterfaceDTO<Disciplina>{

    private Long id;
    private String nome;
    private String turno;
    private Integer horario;
    private Integer sala;
    private List<NotaDTO> notas;

    public void setNotas(List<Nota> notas){
        List<NotaDTO> listNotas = new ArrayList<>();
        for(Nota nota : notas){
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.getData(nota);
            listNotas.add(notaDTO);
        }
        this.notas = listNotas;
    }
    public void getData(Disciplina disciplina){
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.turno = disciplina.getTurno();
        this.horario = disciplina.getHorario();
        this.sala = disciplina.getSala();
    }

    public Disciplina convert(){
        Disciplina disciplina = new Disciplina();
        disciplina.setId(id);
        disciplina.setNome(nome);
        disciplina.setHorario(horario);
        disciplina.setSala(sala);
        return disciplina;
    }
}
