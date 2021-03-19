package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
	
	private  BookingRepository bookingRepository;

//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private AuthoritiesService authoritiesService;

	@Autowired
	public BookingService(  BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	@Transactional
	public void saveBooking(  Booking booking) throws DataAccessException {
		this.bookingRepository.save(booking);
	}
	
	@Transactional(readOnly = true)
	public Booking findBookingById( int id) throws DataAccessException {
		return this.bookingRepository.findById(id).get();
	}

	
	public Collection<Booking> findBookingsByPetId(int petId) {
		return bookingRepository.findByPetId(petId);
	}
}
