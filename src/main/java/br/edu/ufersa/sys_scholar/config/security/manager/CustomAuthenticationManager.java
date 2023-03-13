package br.edu.ufersa.sys_scholar.config.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // User user = userServiceImpl.getUser(authentication.getName());

        // if
        // (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(),
        // user.getPassword())) {
        // throw new BadCredentialsException("You provided an incorrect password.");
        // }

        if (!(authentication.getName().equals("aluno") && authentication.getCredentials().toString().equals("aluno"))) {
            throw new BadCredentialsException("You provided an incorrect password." + authentication.getName()
                    + authentication.getCredentials().toString());
        }

        return new UsernamePasswordAuthenticationToken("aluno", authentication.getCredentials().toString());
    }
}
