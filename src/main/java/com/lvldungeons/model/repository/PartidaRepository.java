package com.lvldungeons.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.Partida;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {

	Partida findByToken(String token);
}
