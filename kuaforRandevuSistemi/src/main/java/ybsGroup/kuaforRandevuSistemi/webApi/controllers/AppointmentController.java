package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
@CrossOrigin
public class AppointmentController {
	
private AppointmentService appointmentService;
@PostMapping("/addAppointment")
public void add(CreateAppointmentRequest createAppointmentRequest) {
	this.appointmentService.add(createAppointmentRequest);
}
}
