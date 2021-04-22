package org.springframework.samples.petclinic.web;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.service.BookingService;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookingValidator implements Validator {
	private static final String REQUIRED = "required";

	
	@Override
	public void validate(Object obj, Errors errors) {
//		Pet pet = (Pet) obj;
//		String name = pet.getName();
		Booking booking = (Booking) obj;
	if(booking.getFechaEntrada()==null||booking.getFechaSalida()==null) {
		errors.rejectValue("fechaEntrada", REQUIRED, REQUIRED);
	}else {
	if(booking.getFechaEntrada().before(Date.valueOf(LocalDate.now()))) {
		errors.rejectValue("fechaEntrada", "error","La fecha de entrada debe ser posterior o igual al día de hoy");
	}
	
	if(booking.getFechaSalida().before(Date.valueOf(LocalDate.now()))) {
		errors.rejectValue("fechaSalida", "error","La fecha de salida debe ser posterior o igual al día de hoy");
	}
	
	if(booking.getFechaSalida()==null ||booking.getFechaSalida().before(booking.getFechaEntrada())) {
		errors.rejectValue("fechaSalida", "error","La fecha de salida debe ser posterior o igual a la fecha de entrada");
	}
	

	}
//		// type validation
//		if (booking.getFechaEntrada().after(booking.getFechaSalida())) {
//			errors.rejectValue("date", REQUIRED, REQUIRED);
//		}
//
//		// birth date validation
//		if (booking.getFechaEntrada()==null || booking.getFechaSalida()==null) {
//			errors.rejectValue("date", REQUIRED, REQUIRED);
//		}
	}

	/**
	 * This Validator validates *just* Booking instances
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

}
