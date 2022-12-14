package com.familyhub.application.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.familyhub.application.model.User;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findByUsername(String username);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
    
    //Optional<User> findByRole(String role);
//    Optional<User> findByUsernameAndRole(String username,String role);
    
    //Page<User> findByUsernameContaining(String username,Pageable pageable);	
}
