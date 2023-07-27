package br.com.api.apitestjunit5.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.apitestjunit5.domain.Users;
import br.com.api.apitestjunit5.repository.UsersRepository;
import br.com.api.apitestjunit5.service.UsersService;
import br.com.api.apitestjunit5.service.exceptions.ObjectNotFoundException;

@Service
public class UsersServiceImp implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findByID(Integer id) {
       Optional<Users> obj = usersRepository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado."));
    }
    
}
