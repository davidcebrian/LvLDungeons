package com.lvldungeons.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.entity.carta.Equipo;

@SuppressWarnings("serial")
@Entity
public class Personaje extends AbstractEntity {

	/*
	 * Constantes
	 */
	private final Integer VIDA_INI = 3;  				//Vida inicial del personaje
	private final Integer MAX_VIDA = 10;  			//Vida maxima del personaje
	private final Integer MIN_VIDA = 0;				//Vida minima del personaje
	private final Integer MAX_ENER = 10;				//Energia maxima del personaje
	private final Integer MIN_ENER = 0;				//Energia minima del personaje
	
	private Integer vida;
	private Integer daño;
	private Integer energia;
	private Boolean vivo;

	private boolean empezarPartida = false;
	
	@OneToOne(mappedBy = "personaje")
	private User usuario;
    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "partida_id")
    private Partida partida;
    
    @OneToMany(mappedBy = "personaje", cascade=CascadeType.ALL)
	private List<Carta> mano;
	
    @OneToMany(mappedBy = "personaje", cascade=CascadeType.ALL)
    private List<Equipo> equipo;
	
	/*
	 * Constructores
	 */
	public Personaje() {
		super();
		this.reiniciarPersonaje();
	}
	
	public Personaje(User usuario) {
		super();
		this.usuario = usuario;
		this.reiniciarPersonaje();
	}

	public Partida getPartida() {
		return this.partida;
	}
	
	public Partida iniciarPartida() {
		this.partida = new Partida(this);
		
		return this.partida;
	}
	
	public void unirsePartida(Partida partida) {
		this.partida = partida;
		partida.addPersonaje(this);
	}

	public Integer getVida() {
		return vida;
	}
	
	public void setVida(Integer vida) {
		if (vida < this.MAX_VIDA && vida > this.MIN_VIDA) {
			this.vida = vida;
		}
	}

	public Integer getDaño() {
		return daño;
	}

	public void setDaño(Integer daño) {
		this.daño = daño;
	}
	
	/*public Integer calcularDaño() { 
		this.equipo.entrySet().stream().filter(Objects::nonNull).forEach((equipo) -> {
			this.daño = this.daño + equipo.getValue().getDaño();
		});
		return this.daño;
	}
*/
	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		if (energia < this.MAX_ENER && energia > this.MIN_ENER) {
			this.energia = energia;			
		}
	}
	
	public Integer reduceEnergia() {
		if (this.energia > this.MIN_ENER) {
			this.energia--;
		}
		
		return this.energia;
	}

	public Boolean getVivo() {
		return vivo;
	}

	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}
	
	public Boolean getEmpezarPartida() {
		return empezarPartida;
	}

	public void setEmpezarPartida(Boolean empezarPartida) {
		this.empezarPartida = empezarPartida;
	}

	public User getUsuario() {
		return usuario;
	}

	/*public List<Carta> getMano() {
		return mano;
	}

	public void elminarCartasMano(List<Carta> cartas) {
		this.mano.removeAll(cartas);
	}
	
	public void addCarta(List<Carta> cartas) {
		this.mano.addAll(cartas);
	}
	*/
	public void reiniciarPersonaje() {
		this.vida = VIDA_INI;
		this.daño = VIDA_INI;
		this.energia = MAX_ENER;
		this.vivo = true;
		
		//this.mano = new ArrayList<Carta>();
		
		/*this.equipo = new HashMap<TipoEquipo, Carta>() {{
			put(TipoEquipo.ARMA_PRINCIPAL, null);
			put(TipoEquipo.ARMA_SECUNDARIA, null);
			put(TipoEquipo.CASCO, null);
			put(TipoEquipo.PETO, null);
			put(TipoEquipo.GREBAS, null);
			put(TipoEquipo.BOTAS, null);
		}};
	*/
	}

	public List<Carta> getMano() {
		return mano;
	}

	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}


}
