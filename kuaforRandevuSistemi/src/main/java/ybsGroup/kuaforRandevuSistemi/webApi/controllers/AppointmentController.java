package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
public class AppointmentController {
	
private AppointmentService appointmentService;
	
@PostMapping("/add")
public void add(@RequestBody() CreateAppointmentRequest createAppointmentRequest) {
	this.appointmentService.add(createAppointmentRequest);
}

}
