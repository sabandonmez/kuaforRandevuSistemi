package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetAllAppointmentsResponse;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;

public interface AppointmentService {
//	List<GetAllAppointmentsResponse> getAllAppointmentByRole(Role role,int userId);
//	GetAllAppointmentsResponse convertToResponse(Appointment appointment);
	void createAppointment(CreateAppointmentRequest createAppointmentRequest);
	List<LocalTime> findAvailableSlots(int hairdresserId, LocalDate date, int totalDuration);
}
 