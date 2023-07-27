package br.com.api.apitestjunit5.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.apitestjunit5.domain.Users;
import br.com.api.apitestjunit5.dto.UsersDTO;
import br.com.api.apitestjunit5.repository.UsersRepository;
import br.com.api.apitestjunit5.service.UsersService;
import br.com.api.apitestjunit5.service.exceptions.DataIntegratyViolationException;
import br.com.api.apitestjunit5.service.exceptions.ObjectNotFoundException;

@Service
public class UsersServiceImp implements UsersService {

   @Autowired
   private UsersRepository usersRepository;

   @Autowired
   private ModelMapper mapper;

   @Override
   public Users findByID(Integer id) {
      Optional<Users> obj = usersRepository.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado."));
   }

   @Override
   public List<Users> findAll() {
      return usersRepository.findAll();
   }

   @Override
   public Users createUsers(UsersDTO usersDTO) {
      findByEmail(usersDTO);
      return usersRepository.save(mapper.map(usersDTO, Users.class));
   }

   private void findByEmail(UsersDTO usersDTO) {
      Optional<Users> user = usersRepository.findByEmail(usersDTO.getEmail());
      if (user.isPresent()) {
         throw new DataIntegratyViolationException("E-mail já cadastrado no sistema.");

      }
   }
}
