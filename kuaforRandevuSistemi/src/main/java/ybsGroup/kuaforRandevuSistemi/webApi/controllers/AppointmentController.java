package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.DeleteAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.UpdateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetAllAppointmentsResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetByIdAppointmentResponse;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Service;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
@CrossOrigin
public class AppointmentController {
	
private AppointmentService appointmentService;
private ServiceRepository serviceRepository;
@PostMapping("/add-appointment")
public void add(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
	this.appointmentService.add(createAppointmentRequest);
}

@GetMapping("get-all-appointment")
public List<GetAllAppointmentsResponse> getAll() {
	return this.appointmentService.getAll();
}
@GetMapping("get-by-id-appointment")
public GetByIdAppointmentResponse getById(int id) {
	return this.appointmentService.getById(id);
}

@PutMapping("update-appointment")
public void update(UpdateAppointmentRequest appointmentRequest) {
	this.appointmentService.update(appointmentRequest);
}

@DeleteMapping("delete-appointment")
public void delete(DeleteAppointmentRequest deleteAppointmentRequest) {
	this.appointmentService.delete(deleteAppointmentRequest);
}

@GetMapping("/available-slots")
public List<LocalTime> getAvailableSlots(@RequestParam int workerId, 
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                         @RequestParam List<Integer> serviceIds) {

    List<Service> selectedServices = serviceIds.stream()
                                               .map(id -> serviceRepository.findById(id).orElseThrow())
                                               .collect(Collectors.toList());

    return appointmentService.findAvailableSlots(workerId, date, selectedServices);
}
}
