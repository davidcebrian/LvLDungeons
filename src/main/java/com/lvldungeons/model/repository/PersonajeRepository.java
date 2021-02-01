package com.lvldungeons.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.Personaje;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
	

}
