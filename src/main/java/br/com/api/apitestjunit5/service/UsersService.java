package br.com.api.apitestjunit5.service;

import java.util.List;

import br.com.api.apitestjunit5.domain.Users;
import br.com.api.apitestjunit5.dto.UsersDTO;

public interface UsersService {
    
    Users findByID(Integer id);

    List<Users> findAll();

    Users createUsers(UsersDTO usersDTO);
}
