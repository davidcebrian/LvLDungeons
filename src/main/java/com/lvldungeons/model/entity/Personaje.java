package com.lvldungeons.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Personaje implements Serializable {

	/*
	 * Constantes
	 */
	private static final int VIDA_INI = 3;  				//Vida inicial del personaje
	private static final int MAX_VIDA = 10;  			//Vida maxima del personaje
	private static final int MIN_VIDA = 0;				//Vida minima del personaje
	private static final int MAX_ENER = 10;				//Energia maxima del personaje
	private static final int MIN_ENER = 0;				//Energia minima del personaje
	private static final int MAX_MANO_VIVO_FINAL = 5;	//Maximo de cartas en la mano al finalizar un turno.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersonaje;
	private String nickname;
	private int vida;
	private int daño;
	private int energia;
	
	@OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL)
	private Baraja mano;
	
	@OneToMany(mappedBy = "personaje")
	private List<Carta> equipamiento;
	private boolean vivo;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private User usuario;
	
	
	/*
	 * Constructores
	 */
	public Personaje() {
		super();
		equipamiento = new ArrayList<Carta>();
	}
	
	public Personaje(User usuario, Baraja mano) {
		super();
		this.usuario = usuario;
		this.idPersonaje = usuario.getIdUsuario();
		this.nickname = usuario.getUsername();
		this.vida = VIDA_INI;
		this.daño = VIDA_INI;
		this.energia = MAX_ENER;
		this.vivo = true;
		equipamiento = new ArrayList<Carta>();
	}

	
	/*
	 * Getters y Setters
	 */
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public Baraja getMano() {
		return mano;
	}

	public void setMano(Baraja mano) {
		this.mano = mano;
	}

	public List<Carta> getEquipamiento() {
		return equipamiento;
	}

	public void setEquipamiento(List<Carta> equipamiento) {
		this.equipamiento = equipamiento;
	}

	public boolean isVivo() {
		return vivo;
	}
	
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public static int getMaxVida() {
		return MAX_VIDA;
	}

	public static int getMinVida() {
		return MIN_VIDA;
	}

	public static int getMaxEner() {
		return MAX_ENER;
	}

	public static int getMinEner() {
		return MIN_ENER;
	}

	public static int getMaxManoVivoFinal() {
		return MAX_MANO_VIVO_FINAL;
	}

	public long getIdPersonaje() {
		return idPersonaje;
	}

	public String getNickname() {
		return nickname;
	}
	
	
	
	
	
}
