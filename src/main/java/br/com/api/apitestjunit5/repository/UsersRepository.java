package br.com.api.apitestjunit5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.apitestjunit5.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
}
