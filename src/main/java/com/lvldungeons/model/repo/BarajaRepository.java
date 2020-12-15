package com.lvldungeons.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvldungeons.model.entity.Baraja;

@Repository
public interface BarajaRepository extends CrudRepository<Baraja, Long> {

}

