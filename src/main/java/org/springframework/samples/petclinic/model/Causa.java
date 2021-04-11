package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "causas")
public class Causa extends BaseEntity{
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
	
	
	@Column(name = "descripcion")
	@NotEmpty
	private String descripcion;
	
	
	@Column(name = "organizacion")
	@NotEmpty
	private String organizacion;
	
	
	@Column(name = "objetivo")
	@NotEmpty
	private Double objetivo;
	
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;


	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getOrganizacion() {
		return organizacion;
	}
	
	public Double getObjetivo() {
		return objetivo;
	}


}
