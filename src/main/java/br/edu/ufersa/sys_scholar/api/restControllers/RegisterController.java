package br.edu.ufersa.sys_scholar.api.restControllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.DiretorDTO;
import br.edu.ufersa.sys_scholar.api.dto.ProfessorDTO;
import br.edu.ufersa.sys_scholar.domain.service.AlunoService;
import br.edu.ufersa.sys_scholar.domain.service.DiretorService;
import br.edu.ufersa.sys_scholar.domain.service.ProfessorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class RegisterController {

    private AlunoService alunoService;
    private ProfessorService professorService;
    private DiretorService diretorService;

    // Procurar por codigo

    @PostMapping("/aluno")
    public ResponseEntity<AlunoDTO> registerAluno(@Valid @RequestBody AlunoDTO alunoDTO) {
        return new ResponseEntity<>(alunoService.registerAluno(alunoDTO),
                HttpStatus.CREATED);

    }

    @PostMapping("/professor")
    public ResponseEntity<ProfessorDTO> registerProfessor(@Valid @RequestBody ProfessorDTO professorDTO) {
        return new ResponseEntity<>(professorService.registerProfessor(professorDTO),
                HttpStatus.CREATED);
    }

    @PostMapping("/diretor")
    public ResponseEntity<DiretorDTO> registerDiretor(@Valid @RequestBody DiretorDTO diretorDTO) {
        return new ResponseEntity<>(diretorService.registerDiretor(diretorDTO),
                HttpStatus.CREATED);
    }
}
