package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking extends BaseEntity{
	
	
	@Column(name="fecha_entrada")
	private Date fechaEntrada;
	
	@Column(name="fecha_salida")
	private Date fechaSalida;
		
	@Column(name = "info")
	private String info;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	
	public Date getFechaSalida() {
		return fechaSalida;
	}

	
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	
	public String getInfo() {
		return info;
	}

	
	public void setInfo(String info) {
		this.info = info;
	}

	
	public Pet getPet() {
		return pet;
	}

	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
	
	


	
	

}
