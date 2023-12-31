package br.com.api.apitestjunit5.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.apitestjunit5.domain.Users;
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
    public ResponseEntity<UsersDTO> findByID(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(usersService.findByID(id), UsersDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UsersDTO>> findAll() {
        return ResponseEntity.ok().body(usersService.findAll().stream()
                .map(x -> mapper.map(x, UsersDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UsersDTO usersDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(usersService.createUsers(usersDTO).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsersDTO> updateUsers(@PathVariable Integer id, @RequestBody UsersDTO usersDTO){
        usersDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(usersService.updatUsers(usersDTO), UsersDTO.class));
    }
}
