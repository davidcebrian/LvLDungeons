package com.lvldungeons.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	

}
