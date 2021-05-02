package org.springframework.samples.petclinic.repository;




import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Donation;

public interface DonationRepository extends Repository<Donation, Integer>{

	Donation save(Donation entity);

	Donation findById(int donationId);
	
	@Query("SELECT donat FROM Donation donat WHERE donat.causa.id =:id")
	Collection<Donation> findByCausa(@Param("id") int id);


	
}
