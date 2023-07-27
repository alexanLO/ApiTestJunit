package br.com.api.apitestjunit5.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.api.apitestjunit5.domain.Users;
import br.com.api.apitestjunit5.repository.UsersRepository;

@Configuration
@Profile("local")
public class LocalConfig {
    
    @Autowired
    private UsersRepository usersRepository;

    @Bean
    public void startDB(){
        Users u1 = new Users(null, "Kunglao", "kl@email.com", "123");
        Users u2 = new Users(null, "Milena", "milena@email.com", "123");
    
        usersRepository.saveAll(List.of(u1, u2));

    }
}
