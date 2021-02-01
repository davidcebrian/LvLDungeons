package com.lvldungeons.service;

import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Baraja;
import com.lvldungeons.model.entity.Carta;
import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.User;

@Service
public class UpdateService {

	
	/*
	 * Todos los metodos de este servicio hacen exactamente lo mismo, recoge dos objetos del mismo tipo, y van a tratar de actualizar los campos que hayan cambiado,
	 * para eso, por cada uno de los atributos del nuevo objeto se compara con null, si contienen informacion se cambian, sino, se mantiene el original.
	 */
	
	public void updateUser (User original, User sent) {
		original.setNombre((sent.getNombre() == null) ? original.getNombre() : sent.getNombre());
		original.setEmail((sent.getEmail() == null) ? original.getEmail() : sent.getEmail());
		original.setEdad((sent.getEdad() <= 0) ? original.getEdad() : sent.getEdad());
		original.setUsername((sent.getUsername() == null) ? original.getUsername() : sent.getUsername());
		original.setPassword((sent.getPassword() == null) ? original.getPassword() : sent.getPassword());
	}


	public void updateBaraja(Baraja original, Baraja sent) {
		original.setCartas((sent.getCartas() == null) ? original.getCartas() : sent.getCartas());
		original.setPersonaje((sent.getPersonaje() == null) ? original.getPersonaje() : sent.getPersonaje());
		original.setTipo((sent.getTipo() == null) ? original.getTipo() : sent.getTipo());
			
	}

	public void updateCarta(Carta original, Carta sent) {
		original.setBaraja((sent.getBaraja() == null) ? original.getBaraja() : sent.getBaraja());
		original.setDaño((sent.getDaño() < 0) ? original.getDaño() : sent.getDaño());
		original.setDiseño((sent.getDiseño() == null) ? original.getDiseño() : sent.getDiseño());
		original.setEfecto((sent.getEfecto() == null) ? original.getEfecto() : sent.getEfecto());
		original.setNombre((sent.getNombre() == null) ? original.getNombre() : sent.getNombre());
		original.setTipoCarta((sent.getTipoCarta() == null) ? original.getTipoCarta() : sent.getTipoCarta());
	}
}
