package br.edu.ufersa.sys_scholar.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.edu.ufersa.sys_scholar.config.security.filter.AuthenticationFilter;
import br.edu.ufersa.sys_scholar.config.security.filter.JWTAuthorizationFilter;
import br.edu.ufersa.sys_scholar.config.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/login");
        http
                .cors(Customizer.withDefaults())
                .csrf().disable()
                .authorizeRequests()
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

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // Configure the allowed origins as per your requirements
        configuration.addAllowedMethod("*"); // Configure the allowed methods as per your requirements
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}