package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.service.AuthoritiesService;
import org.springframework.samples.petclinic.service.BookingService;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {
	
	private static final String VIEWS_BOOKING_CREATE_OR_UPDATE_FORM = "bookings/createOrUpdateBookingForm";
	
	private final BookingService bookingService;
	
	private final PetService petService;

	
	@Autowired
	public BookingController(  final BookingService bookingService,final PetService petService,   final UserService userService,  final AuthoritiesService authoritiesService) {
		this.bookingService = bookingService;
		this.petService = petService;
	}
	@InitBinder("booking")
	public void initBookingBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new BookingValidator());
	}
	
	@InitBinder
	public void setAllowedFields(  final WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("booking")
	public Booking loadBooking(@PathVariable("petId") final int petId) {
		final Pet pet = this.petService.findPetById(petId);
		final Booking booking = new Booking();
		booking.setPet(pet);
		return booking;
	}
	
	@GetMapping(value = "/owners/*/pets/{petId}/bookings/new")
	public String initCreationForm(  @PathVariable("petId") final int petId, final Map<String, Object> model) {
		return BookingController.VIEWS_BOOKING_CREATE_OR_UPDATE_FORM;
	}
	
	
	@PostMapping(value = "/owners/{ownerId}/pets/{petId}/bookings/new")
	public String processCreationForm(@Valid final   Booking booking,  final BindingResult result,final Map<String, Object> model) {
		if (result.hasErrors()) {
			return BookingController.VIEWS_BOOKING_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.bookingService.saveBooking(booking);
			
			return "redirect:/owners/"+booking.getPet().getOwner().getId();
		}
	}
	
	
//	@GetMapping(value = "/bookings/{bookingId}/edit")
//	public String initUpdateBookingForm(@PathVariable("bookingId") final   int bookingId,  final Model model) {
//		final Booking booking = this.bookingService.findBookingById(bookingId);
//		model.addAttribute(booking);
//		return BookingController.VIEWS_BOOKING_CREATE_OR_UPDATE_FORM;
//	}
//
//	
//	@PostMapping(value = "/bookings/{bookingId}/edit")
//	public String processUpdateBookingForm(@Valid final Booking booking, final BindingResult result,
//			@PathVariable("bookingId") final int bookingId) {
//		if (result.hasErrors()) {
//			return BookingController.VIEWS_BOOKING_CREATE_OR_UPDATE_FORM;
//		}
//		else {
//			booking.setId(bookingId);
//			this.bookingService.saveBooking(booking);
//			return "redirect:/owners/"+booking.getPet().getOwner().getId();
//		}
//	}
	
	
	@GetMapping(value="/bookings/{petId}")
	public String showBooking(@PathVariable("petId") final int petId,final Map<String, Object> model) {
		model.put("bookings", this.bookingService.findBookingsByPetId(petId));
		return "bookings/bookingDetails";
	}

}	












