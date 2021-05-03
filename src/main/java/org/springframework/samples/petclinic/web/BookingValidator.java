package org.springframework.samples.petclinic.web;

import java.sql.Date;
import java.time.LocalDate;


import org.springframework.samples.petclinic.model.Booking;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookingValidator implements Validator {
	private static final String REQUIRED = "required";
    private static final String ERROR = "error";
	@Override
	public void validate(Object obj, Errors errors) {
		Booking booking = (Booking) obj;
		if (booking.getFechaEntrada() == null || booking.getFechaSalida() == null) {
			errors.rejectValue("fechaEntrada", REQUIRED, REQUIRED);
		} else {
			if (booking.getFechaEntrada().before(Date.valueOf(LocalDate.now()))) {
				errors.rejectValue("fechaEntrada", ERROR,
						"La fecha de entrada debe ser posterior o igual al día de hoy");
			}

			if (booking.getFechaSalida().before(Date.valueOf(LocalDate.now()))) {
				errors.rejectValue("fechaSalida", ERROR,
						"La fecha de salida debe ser posterior o igual al día de hoy");
			}

			if (booking.getFechaSalida() == null || booking.getFechaSalida().before(booking.getFechaEntrada())) {
				errors.rejectValue("fechaSalida", ERROR,
						"La fecha de salida debe ser posterior o igual a la fecha de entrada");
			}

		}
	}

	/**
	 * This Validator validates *just* Booking instances
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

}
