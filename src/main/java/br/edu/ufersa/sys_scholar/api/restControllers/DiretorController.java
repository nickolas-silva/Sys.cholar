package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/diretor")
@AllArgsConstructor
public class DiretorController {

    DiretorService diretorService;
    ProfessorService professorService;
    AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<DiretorDTO>> getDiretores() {
        return new ResponseEntity<>(diretorService.getDiretores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> getDiretor(@PathVariable Long id) {
        return new ResponseEntity<>(diretorService.getDiretor(id), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<DiretorDTO> createDiretor() {
        return new ResponseEntity<>(diretorService.saveDiretor(null), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDiretor(@PathVariable Long id) {
        diretorService.deleteDiretor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity<DiretorDTO> updateDiretor(@Valid @RequestBody DiretorDTO diretorDTO) {
        return new ResponseEntity<>(diretorService.updateDiretor(diretorDTO), HttpStatus.OK);
    }

    @GetMapping("/aluno")
    public ResponseEntity<List<AlunoDTO>> getAlunos() {
        return new ResponseEntity<>(alunoService.getAlunos(), HttpStatus.OK);
    }

    @GetMapping("/create/aluno")
    public ResponseEntity<AlunoDTO> createAluno() {
        return new ResponseEntity<>(alunoService.saveAluno(null), HttpStatus.CREATED);
    }

    @GetMapping("professor")
    public ResponseEntity<List<ProfessorDTO>> getProfessores() {
        return new ResponseEntity<>(professorService.getProfessores(), HttpStatus.OK);
    }

    @GetMapping("/create/professor")
    public ResponseEntity<ProfessorDTO> createProfessor() {
        return new ResponseEntity<>(professorService.saveProfessor(null),
                HttpStatus.OK);
    }

}