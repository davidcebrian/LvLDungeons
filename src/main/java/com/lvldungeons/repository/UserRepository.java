package com.lvldungeons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	

}
