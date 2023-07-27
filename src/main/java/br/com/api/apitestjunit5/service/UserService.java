package br.com.api.apitestjunit5.service;

import br.com.api.apitestjunit5.domain.User;

public interface UserService {
    
    User findByID(Integer id);
}
