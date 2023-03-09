package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.domain.repository.AlunoRepository;
import br.edu.ufersa.sys_scholar.domain.service.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    AlunoService alunoService;
    AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAlunos() {
        return new ResponseEntity<>(alunoService.getAlunos(), HttpStatus.OK);
    }

}
