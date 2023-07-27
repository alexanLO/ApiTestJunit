package br.com.api.apitestjunit5.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.apitestjunit5.domain.User;
import br.com.api.apitestjunit5.repository.UserRepository;
import br.com.api.apitestjunit5.service.UserService;
import br.com.api.apitestjunit5.service.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository usersRepository;

    @Override
    public User findByID(Integer id) {
       Optional<User> obj = usersRepository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado."));
    }
    
}
