package br.edu.ufersa.sys_scholar.config.security.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ufersa.sys_scholar.api.dto.UserDTO;
import br.edu.ufersa.sys_scholar.config.security.SecurityConstants;
import br.edu.ufersa.sys_scholar.config.security.utils.RequestPathFilters;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith(SecurityConstants.BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace(SecurityConstants.BEARER, "");

        String payload = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                .build()
                .verify(token)
                .getPayload();

        String jsonPayload = StringUtils.newStringUtf8(Base64.decodeBase64(payload));

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        UserDTO userDTO = mapper.readValue(jsonPayload, UserDTO.class);

        ///////////////////////

        RequestPathFilters pathFilter = new RequestPathFilters(request.getRequestURI(), userDTO);

        // final String currentPath = request.getRequestURI();

        if ((!pathFilter.isAuthorizedToPathAluno()) &&
                (!pathFilter.isAuthorizedToPathProfessor())) {
            filterChain.doFilter(request, response);
            return;
        }

        // if (pathFilter.isAluno()) {
        // filterChain.doFilter(request, response);
        // return;
        // }

        // System.out.println("path -> " + currentPath);

        ///////////////////////

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDTO, null, Arrays.asList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
