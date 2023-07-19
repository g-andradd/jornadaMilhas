package br.com.alura.jornadamilhas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@SpringBootApplication
public class JornadaMilhasApplication {

    public static void main(String[] args) {
        SpringApplication.run(JornadaMilhasApplication.class, args);
    }

}
