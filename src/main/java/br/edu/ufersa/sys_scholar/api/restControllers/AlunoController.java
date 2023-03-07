package br.edu.ufersa.sys_scholar.api.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @GetMapping
    public ResponseEntity<String> getAlunos() {
        return new ResponseEntity<>("testando controller", HttpStatus.OK);
    }

}
