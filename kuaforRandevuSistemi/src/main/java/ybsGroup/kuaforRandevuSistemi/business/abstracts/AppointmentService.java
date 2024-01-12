package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.DeleteAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetAllAppointmentsResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetByIdAppointmentResponse;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;

public interface AppointmentService {
	List<GetAllAppointmentsResponse> getAll();
	GetByIdAppointmentResponse getById(int id);
	List<LocalTime> findAvailableSlots(int workerId, LocalDate appointmentDate, List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> selectedServices);
	void add(CreateAppointmentRequest createAppointmentRequest);
	void delete(DeleteAppointmentRequest deleteAppointmentRequest);
}