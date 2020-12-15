package com.lvldungeons.service;

import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.User;

@Service
public class UpdateService {

	public void updateUser (User original, User sent) {
		original.setNombre((sent.getNombre() == null) ? original.getNombre() : sent.getNombre());
		original.setEmail((sent.getEmail() == null) ? original.getEmail() : sent.getEmail());
		original.setEdad((sent.getEdad() <= 0) ? original.getEdad() : sent.getEdad());
		original.setNick((sent.getNick() == null) ? original.getNick() : sent.getNick());
		original.setPass((sent.getPass() == null) ? original.getPass() : sent.getPass());
	}

	public void updatePersonaje(Personaje original, Personaje sent) {
		original.setDaño((sent.getDaño() < 0) ? original.getDaño() : sent.getDaño());
		original.setEnergia((sent.getEnergia() < 0) ? original.getEnergia() : sent.getEnergia());
		original.setEquipamiento((sent.getEquipamiento() == null) ? original.getEquipamiento() : sent.getEquipamiento());
		original.setMano((sent.getMano()== null) ? original.getMano() : sent.getMano());
		original.setUsuario((sent.getUsuario() == null) ? original.getUsuario() : sent.getUsuario());
		original.setVida((sent.getVida() < 0) ? original.getVida() : sent.getVida());
		original.setVivo((sent.isVivo()) ? original.isVivo() : sent.isVivo());

	}
}
