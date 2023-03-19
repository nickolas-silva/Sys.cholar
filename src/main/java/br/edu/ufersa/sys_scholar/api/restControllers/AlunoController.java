package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import br.edu.ufersa.sys_scholar.domain.service.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;

    @RequestMapping(value = { "/{id}", "" }, method = RequestMethod.GET)
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Optional<Long> id) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDTO.isDiretor()) {
            return new ResponseEntity<>(alunoService.getAluno(id.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(alunoService.getAluno(userDTO.getId()), HttpStatus.OK);

    }

    @RequestMapping(value = { "/{id}", "" }, method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAluno(@PathVariable Optional<Long> id) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDTO.isDiretor()) {
            alunoService.deleteAluno(id.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        alunoService.deleteAluno(userDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity<AlunoDTO> updateAluno(@Valid @RequestBody AlunoDTO alunoDTO) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if ((alunoDTO.getId() != userDTO.getId()) && (!userDTO.isDiretor())) {
            return new ResponseEntity<>(null, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        return new ResponseEntity<>(alunoService.updateAluno(alunoDTO), HttpStatus.OK);
    }

    // updateAluno

}
