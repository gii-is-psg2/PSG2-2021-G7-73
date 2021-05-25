package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "donations")
public class Donation extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "cause_id")
	private Causa causa;
	
	@Column(name =  "date_of_donation")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;

	@Column(name = "amount")
	@Min(1)
	private Double amount;

	@Column(name="client")
	private String client;

	

	
	public Causa getCausa() {
		return this.causa;
	}

	public void setCausa(Causa causa) {
		this.causa = causa;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
