package br.com.api.apitestjunit5.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.apitestjunit5.domain.Users;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(new Users(1, "Valdir", "valdir@email.com", "123"));
    }
}
