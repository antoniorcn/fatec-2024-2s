package edu.curso.agendacontato;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() { 
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) 
                                                        throws Exception{
        http
            .csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests(
                (authorize)->{
                    authorize.requestMatchers("**").permitAll();
                    authorize.anyRequest().authenticated();
                }
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailService() {
        UserDetails joao = User.builder()
                .username("joao@teste.com")
                .password(encoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails maria = User.builder()
                .username("maria@teste.com")
                .password(encoder().encode("1234"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(joao, maria);
    }
    
}
