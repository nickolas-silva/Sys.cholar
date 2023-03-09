package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.sys_scholar.api.dto.DisciplinaDTO;
import br.edu.ufersa.sys_scholar.api.dto.NotaDTO;
import br.edu.ufersa.sys_scholar.domain.entity.Disciplina;
import br.edu.ufersa.sys_scholar.domain.entity.Nota;
import br.edu.ufersa.sys_scholar.domain.repository.NotaRepository;
import br.edu.ufersa.sys_scholar.domain.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @Autowired
    NotaRepository notaRepository;

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> getDisciplinas() {
        return new ResponseEntity<>(disciplinaService.getDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> getDisciplina(@PathVariable Long id) {
        return new ResponseEntity<>(disciplinaService.getDisciplina(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDisciplina(@PathVariable Long id) {
        disciplinaService.deleteDisciplina(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @Valid adicionar essa annotation
    @PostMapping
    public ResponseEntity<DisciplinaDTO> saveDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        return new ResponseEntity<>(disciplinaService.saveDisciplina(disciplinaDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{disciplinaId}/{alunoId}")
    public ResponseEntity<HttpStatus> atribuirAluno(@PathVariable Long disciplinaId, @PathVariable Long alunoId) {
        disciplinaService.atribuirAluno(disciplinaId, alunoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/nota")
    public ResponseEntity<DisciplinaDTO> updateDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        return new ResponseEntity<>(disciplinaService.updateDisciplina(disciplinaDTO), HttpStatus.OK);
    }

}
