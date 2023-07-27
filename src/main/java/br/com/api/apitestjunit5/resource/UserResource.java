package br.com.api.apitestjunit5.resource;

import javax.xml.validation.Validator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.apitestjunit5.domain.User;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(new User(1, "Valdir", "valdir@email.com", "123"));
    }
}
