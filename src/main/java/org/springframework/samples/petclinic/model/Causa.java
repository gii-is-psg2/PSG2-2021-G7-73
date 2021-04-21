package org.springframework.samples.petclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;


@Entity
@Table(name = "causas")
public class Causa extends BaseEntity{
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "organizacion")
	private String organizacion;
	
	@Column(name = "num")
	@DecimalMin("0.0")
	private Double num;


	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getOrganizacion() {
		return organizacion;
	}
	
	public Double getNum() {
		return num;
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
	
	public void setNum(Double num) {
		this.num = num;
	}


}
