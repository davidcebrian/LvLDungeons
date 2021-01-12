package com.lvldungeons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.DatosAutenticacionUsuario;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.repo.UserRepository;


@Service
public class UserService {

	
	//Repositorios
	@Autowired
	private UserRepository userRepo;
	
	//Servicios
	@Autowired
	private UpdateService updateService;
	
	
	//Autenticacion de usuario, devolviendo jwt creado a partir de un usuario.
//		public JSON autenticaUsuario(DatosAutenticacionUsuario datos) {
//			User usuarioAutenticado = userRepo.findByNickAndPass(datos.getUsuario(), datos.getPassword());
//			if(usuarioAutenticado != null) {
//				JSON jwt = 
//			}
//			
//			return usuarioAutenticado;
//		}
	
	//Get de todos los users
		public List<User> getEntity() {
			 return (List<User>)userRepo.findAll();
		}
		
		
	//Get de un user por id
		public User getEntityById(Long id) {
			return userRepo.findById(id).get();
		}
		
		//Crear un nuevo user
		public User saveEntity(User sent) {
			return userRepo.save(sent);
		}
		
		//Actualziar un user
		public User updateEntity(Long id, User sent) {
			User us = userRepo.findById(id).get();
			
			if(us !=null) {
				updateService.updateUser(us, sent);
				userRepo.save(us);
			}
			return us;
		}
		
		//Borrar un user
		public void deleteEntity(Long id) {
			userRepo.deleteById(id);
		}
}
