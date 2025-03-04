package parcial3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Configuración de seguridad para la aplicación.
 * <p>
 * Se usa Spring Security con WebFlux para controlar el acceso a la API.
 * En esta configuración:
 * <ul>
 *   <li>Se desactiva la protección CSRF.</li>
 *   <li>Se permite el acceso sin autenticación a todas las peticiones.</li>
 *   <li>Se deshabilita la autenticación básica y el login por formulario.</li>
 * </ul>
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * Configura la seguridad del servidor web.
     *
     * @param http Configuración de seguridad de Spring Security para WebFlux.
     * @return Cadena de filtros de seguridad aplicada a la aplicación.
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable) // 🔹 Desactiva la protección CSRF
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().permitAll() // 🔹 Permite todas las peticiones sin autenticación
                )
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable) // 🔹 Desactiva autenticación básica
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable); // 🔹 Desactiva el login por formulario

        return http.build();
    }
}
