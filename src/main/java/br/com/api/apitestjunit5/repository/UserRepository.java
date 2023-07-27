package br.com.api.apitestjunit5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.apitestjunit5.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
