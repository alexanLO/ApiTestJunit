package br.com.api.apitestjunit5.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.apitestjunit5.dto.UserDTO;
import br.com.api.apitestjunit5.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService usersService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(usersService.findByID(id), UserDTO.class));
    }
}
