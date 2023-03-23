package br.edu.ufersa.sys_scholar.api.restControllers;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufersa.sys_scholar.api.dto.AlunoDTO;
import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import br.edu.ufersa.sys_scholar.api.exception.EntityNotExistsException;
import br.edu.ufersa.sys_scholar.api.exception.InvalidCredencialsException;
import br.edu.ufersa.sys_scholar.api.exception.InvalidIdentifierException;
import br.edu.ufersa.sys_scholar.domain.repository.AlunoRepository;
import br.edu.ufersa.sys_scholar.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = { "/{id}", "" }, method = RequestMethod.GET)
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Optional<Long> id) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDTO.isDiretor()) {
            return new ResponseEntity<>(alunoService.getAluno(id.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(alunoService.getAluno(userDTO.getId()), HttpStatus.OK);

    }

    @RequestMapping(value = { "/{id}", "" }, method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAluno(@PathVariable Optional<Long> id,
            @RequestBody Optional<UserDTO> validateUserDTO) {
        final UserDTO contextUser = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (contextUser.isDiretor()) {
            alunoService.deleteAluno(id.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        final AlunoDTO currentAluno = alunoService.getAluno(contextUser.getId());

        if (!validateUserDTO.isPresent() ||
                !bCryptPasswordEncoder.matches(validateUserDTO.get().getSenha(),
                        currentAluno.getSenha())) {
            throw new InvalidCredencialsException("Senha");
        }

        alunoService.deleteAluno(contextUser.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity<AlunoDTO> updateAluno(@Valid @RequestBody AlunoDTO alunoDTO) {
        final UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if ((alunoDTO.getId() != userDTO.getId()) && (!userDTO.isDiretor())) {
            // return new ResponseEntity<>(null, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            throw new InvalidIdentifierException();
        }

        return new ResponseEntity<>(alunoService.updateAluno(alunoDTO), HttpStatus.OK);
    }

    // updateAluno

}
