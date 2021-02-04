package com.lvldungeons.model.entity.base;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private LocalDate fechaEliminacion;
	
	public AbstractEntity() {
		super();
		this.fechaCreacion = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public LocalDate getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(LocalDate fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
}
