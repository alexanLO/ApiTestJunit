package br.com.api.apitestjunit5.service;

import br.com.api.apitestjunit5.domain.Users;

public interface UsersService {
    
    Users findByID(Integer id);
}
