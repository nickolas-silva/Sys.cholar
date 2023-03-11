package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.List;
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
import br.edu.ufersa.sys_scholar.api.dto.DiretorDTO;
import br.edu.ufersa.sys_scholar.domain.service.DiretorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/diretor")
@AllArgsConstructor
public class diretorController {

    DiretorService diretorService;

    @GetMapping
    public ResponseEntity<List<DiretorDTO>> getDiretores() {
        return new ResponseEntity<>(diretorService.getDiretores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> getDiretor(@PathVariable Long id) {
        return new ResponseEntity<>(diretorService.getDiretor(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DiretorDTO> saveDiretor(@RequestBody DiretorDTO diretorDTO) {
        return new ResponseEntity<>(diretorService.saveDiretor(diretorDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDiretor(@PathVariable Long id) {
        diretorService.deleteDiretor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<DiretorDTO> updateDiretor(@RequestBody DiretorDTO diretorDTO) {
        return new ResponseEntity<>(diretorService.updateDiretor(diretorDTO), HttpStatus.OK);
    }
}