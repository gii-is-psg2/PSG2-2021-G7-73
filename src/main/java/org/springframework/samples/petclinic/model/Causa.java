package org.springframework.samples.petclinic.model;


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
	private Double totalBudget;


	@Column(name = "num")
	@DecimalMin("0.0")
	private Double num;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="causa", fetch = FetchType.EAGER)
	private List<Donation> donations;

	
	public List<Donation> getDonations() {
		return this.donations;
	}


	public void listDonations(final List<Donation> donations) {
		this.donations = donations;
	}


	public Double getNum() {
		return this.num;
	}

	public Double getTotalBudget() {
		return this.totalBudget;
	}
	
	public void setTotalBudget(final Double budget) {
		this.totalBudget=budget;
	}

	public void setNum(final Double num) {
		this.num = num;
	}



	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getOrganizacion() {
		return this.organizacion;
	}


	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public void setOrganizacion(final String organizacion) {
		this.organizacion = organizacion;
	}



	public List<Donation> findDonations() {
		return this.donations.stream().collect(Collectors.toList());

	}


	public void addDonation(final Donation donation) {
		this.totalBudget=donation.getAmount();

	}


}
