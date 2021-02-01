package com.lvldungeons.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
	// Esta query pretende obtener un usuario desde el username y la contraseña, se usa para el login.
	@Query(value = "SELECT * FROM user u WHERE u.username LIKE %?1% AND u.password LIKE %?2%", nativeQuery=true)
	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
	
	User findByEmail(String email);
	
}
