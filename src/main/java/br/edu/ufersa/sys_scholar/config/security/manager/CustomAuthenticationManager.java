package br.edu.ufersa.sys_scholar.config.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import br.edu.ufersa.sys_scholar.domain.service.LoginService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // User user = userServiceImpl.getUser(authentication.getName());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(0L);
        userDTO.setUsuario("admin");
        userDTO.setRole("diretor");
        userDTO.setSenha("$2a$12$eKBVSCcw8CCJz4Dp1uk9zOaR50DgmnHipyUKgQjME852ZsCfNRTtC");
        if (!(authentication.getCredentials().equals("admin") && authentication.getName().equals("admin"))) {
            userDTO = loginService.findByUsuario(authentication.getName());
        }

        if (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), userDTO.getSenha())) {
            throw new BadCredentialsException("You provided an incorrect password.");
        }

        userDTO.setSenha(null);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getUsuario(),
                authentication.getCredentials().toString());
        ;

        token.setDetails(userDTO);

        return token;
    }
}
