package br.edu.ufersa.sys_scholar.config.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)"; // Your
                                                                                                                // secret
                                                                                                                // should
                                                                                                                // always
                                                                                                                // be
                                                                                                                // strong
                                                                                                                // (uppercase,
                                                                                                                // lowercase,
                                                                                                                // numbers,
                                                                                                                // symbols)
                                                                                                                // so
                                                                                                                // that
                                                                                                                // nobody
                                                                                                                // can
                                                                                                                // potentially
                                                                                                                // decode
                                                                                                                // the
                                                                                                                // signature.
    public static final int TOKEN_EXPIRATION = 7200000; // 7200000 milliseconds = 7200 seconds = 2 hours.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String ALUNO_REGISTER_PATH = "/register/aluno";
    public static final String PROFESSOR_REGISTER_PATH = "/register/professor"; // Public path that clients can use to
    // register.
    public static final String DIRETOR_REGISTER_PATH = "/register/diretor"; // Public path that clients can use to
                                                                            // register.

}