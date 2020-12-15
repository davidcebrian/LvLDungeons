package com.lvldungeons.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.Carta;

@Repository
public interface CartaRepository extends CrudRepository<Carta, Long> {
	

}

