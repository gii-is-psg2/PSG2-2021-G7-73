package org.springframework.samples.petclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "causas")
public class Causa extends BaseEntity{
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@Column(name = "organizacion")
	private String organizacion;
	
	
	@Column(name = "objetivo")
	private Double objetivo;
	


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
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}
	
	public void setObejtivo(Double objetivo) {
		this.objetivo = objetivo;
	}


}
