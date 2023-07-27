package br.com.api.apitestjunit5.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.api.apitestjunit5.domain.User;
import br.com.api.apitestjunit5.repository.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
    
    @Autowired
    private UserRepository usersRepository;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Kunglao", "kl@email.com", "123");
        User u2 = new User(null, "Milena", "milena@email.com", "123");
    
        usersRepository.saveAll(List.of(u1, u2));

    }
}
