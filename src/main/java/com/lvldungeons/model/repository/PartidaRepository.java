package com.lvldungeons.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.User;

public interface PartidaRepository extends CrudRepository<Partida, Long> {

	Partida findByToken(String token);
}
