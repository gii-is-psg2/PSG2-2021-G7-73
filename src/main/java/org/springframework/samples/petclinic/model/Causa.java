package org.springframework.samples.petclinic.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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




	@Column(name = "totalBudget")
	private Integer totalBudget;


	@Column(name = "num")
	@DecimalMin("0.0")
	private Double num;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="causa", fetch = FetchType.EAGER)
	private List<Donation> donations;

	public List<Donation> getDonations() {
		return donations;
	}


	public void listDonations(List<Donation> donations) {
		this.donations = donations;
	}


	public Double getNum() {
		return num;
	}


	public void setNum(Double num) {
		this.num = num;
	}



	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getOrganizacion() {
		return organizacion;
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



	public List<Donation> findDonations() {
		return donations.stream().collect(Collectors.toList());

	}


	public void addDonation(Donation donation) {
		List<Donation> hola= this.getDonations();
		if(hola==null) {
			List<Donation>coleccion = new ArrayList<>();
			coleccion.add(donation);
			this.donations=coleccion;
		}else {
			hola.add(donation);
		}
		donation.setCausa(this);


	}


}
