package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetAllAppointmentsResponse;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
@CrossOrigin
public class AppointmentController {
	
private AppointmentService appointmentService;
	
//@PostMapping("/add")
//public void add(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
//  appointmentService.add(createAppointmentRequest);
//}
//@GetMapping("/getAllAppointments")
//public List<GetAllAppointmentsResponse> getAllAppointmentByRole( @RequestParam Role role, @RequestParam int userId) {
//    List<GetAllAppointmentsResponse> appointments = appointmentService.getAllAppointmentByRole(role, userId);
//    return appointments;
//}
@GetMapping("/availableTimeSlots")
public ResponseEntity<List<LocalTime>> getAvailableTimeSlots(
        @RequestParam int hairdresserId, 
        @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
    
    // totalDuration değişkeni belki de başka bir yerden gelmelidir, örneğin bir konfigürasyon dosyasından.
    int totalDuration = 10; 
    // Doğru çağrıyı yapmak için artık "atStartOfDay()" kullanmamalısınız, çünkü "findAvailableSlots" metodu artık LocalDate alıyor.
    List<LocalTime> availableSlots = appointmentService.findAvailableSlots(hairdresserId, date, totalDuration);
    return ResponseEntity.ok(availableSlots);
}

@PostMapping("/createAppointment")
public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
    appointmentService.createAppointment(createAppointmentRequest);
    return ResponseEntity.ok("Randevu başarıyla oluşturuldu");
}
}