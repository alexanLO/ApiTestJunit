package br.com.api.apitestjunit5.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.apitestjunit5.dto.UsersDTO;
import br.com.api.apitestjunit5.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    
    @Autowired
    private UsersService usersService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersDTO> findByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(usersService.findByID(id), UsersDTO.class));
    }
}
