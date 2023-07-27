package br.com.api.apitestjunit5.service;

import java.util.List;

import br.com.api.apitestjunit5.domain.Users;

public interface UsersService {
    
    Users findByID(Integer id);

    List<Users> findAll();
}
