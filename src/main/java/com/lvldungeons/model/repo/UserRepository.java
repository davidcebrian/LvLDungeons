package com.lvldungeons.model.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
	@Query(value = "SELECT * FROM user u WHERE u.username LIKE %?1% AND u.password LIKE %?2%", nativeQuery=true)
	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
	
	User findByEmail(String email);
	
}
