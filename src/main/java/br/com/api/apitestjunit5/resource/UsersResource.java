package br.com.api.apitestjunit5.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.apitestjunit5.domain.Users;
import br.com.api.apitestjunit5.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(usersService.findByID(id));
    }
}
