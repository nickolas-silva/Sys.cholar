package br.edu.ufersa.sys_scholar.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import br.edu.ufersa.sys_scholar.config.security.filter.AuthenticationFilter;
import br.edu.ufersa.sys_scholar.config.security.manager.CustomAuthenticationManager;
import br.edu.ufersa.sys_scholar.config.security.filter.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;

import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/login");
        http
                .csrf().disable()
                .authorizeRequests()
                // .anyRequest().permitAll();

                .antMatchers(HttpMethod.POST, SecurityConstants.ALUNO_REGISTER_PATH).permitAll()
                .antMatchers(HttpMethod.POST, SecurityConstants.PROFESSOR_REGISTER_PATH).permitAll()
                .antMatchers(HttpMethod.POST, SecurityConstants.DIRETOR_REGISTER_PATH).permitAll()
                .anyRequest().authenticated()
                .and()
                // .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

}