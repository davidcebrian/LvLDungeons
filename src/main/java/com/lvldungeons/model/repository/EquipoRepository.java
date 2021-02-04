package com.lvldungeons.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.carta.Equipo;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Long>{

}
