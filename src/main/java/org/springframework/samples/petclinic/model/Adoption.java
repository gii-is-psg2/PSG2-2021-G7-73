package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "adoptions")
public class Adoption extends NamedEntity{
	
	@NotEmpty
	private Pet pet;
	
	@NotEmpty
	private Owner previousOwner;
	
	
	private Owner actualOwner;

	
	public Pet getPet() {
		return this.pet;
	}

	
	public void setPet(final Pet pet) {
		this.pet = pet;
	}

	
	public Owner getPreviousOwner() {
		return this.previousOwner;
	}

	
	public void setPreviousOwner(final Owner previousOwner) {
		this.previousOwner = previousOwner;
	}

	
	public Owner getActualOwner() {
		return this.actualOwner;
	}

	
	public void setActualOwner(final Owner actualOwner) {
		this.actualOwner = actualOwner;
	}
	
	
}
