package ybsGroup.kuaforRandevuSistemi.business.concretes;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.DeleteAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetByIdAppointmentResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.AppointmentRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;

@Service
@AllArgsConstructor
public class AppointmentManager implements AppointmentService{
	
	AppointmentRepository appointmentRepository;
	ServiceRepository serviceRepository;
	private final ModelMapperService modelMapperService;
	
	@Override
	public void add(CreateAppointmentRequest createAppointmentRequest) {
		Appointment appointment = this.modelMapperService.forRequest().map(createAppointmentRequest, Appointment.class);
		List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services = serviceRepository.findByIdIn(createAppointmentRequest.getServiceIds());
		appointment.setServices(services);
		this.appointmentRepository.save(appointment);
	}
	@Override
	public List<Appointment> getAll() {
		List<Appointment> appointments = appointmentRepository.findAll();
		return appointments;
	}

	@Override
	public GetByIdAppointmentResponse getById(int id) {
		Appointment appointment = appointmentRepository.findById(id).orElseThrow();
		GetByIdAppointmentResponse response = this.modelMapperService.forResponse().map(appointment, GetByIdAppointmentResponse.class);
		return response;
	}

	@Override
	public void delete(DeleteAppointmentRequest deleteAppointmentRequest) {
		this.appointmentRepository.deleteById(deleteAppointmentRequest.getId());
	}

	@Override
	public List<LocalTime> findAvailableSlots(int workerId, LocalDate appointmentDate, List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> selectedServices ) {
		 LocalTime startTime = LocalTime.of(9, 0);
		    LocalTime endTime = LocalTime.of(21, 0);
		    List<LocalTime> allTimeSlots = new ArrayList<>();

		    while (startTime.isBefore(endTime)) {
		        allTimeSlots.add(startTime);
		        startTime = startTime.plusMinutes(10);
		    }

		    List<Appointment> appointments = appointmentRepository.findAllByWorkerIdAndAppointmentDate(workerId, appointmentDate);

		    for (Appointment appointment : appointments) {
		        LocalTime appointmentTime = appointment.getAppointmentDate().toLocalTime();
		        int totalDuration = calculateTotalDuration(appointment.getServices());

		        for (int i = 0; i < totalDuration; i += 10) {
		            LocalTime blockedTime = appointmentTime.plusMinutes(i);
		            allTimeSlots.remove(blockedTime);
		        }
		    }

		    int customerServiceDuration = calculateTotalDuration(selectedServices);

		    return allTimeSlots.stream()
		            .filter(slot -> isSlotAvailable(slot, customerServiceDuration, allTimeSlots))
		            .collect(Collectors.toList());
	}
	

	private int calculateTotalDuration(List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services) {
	    int totalDuration = 0;
	    for (ybsGroup.kuaforRandevuSistemi.entities.concretes.Service service : services) {
	        totalDuration += service.getDuration();
	    }
	    return totalDuration;
	}

	private boolean isSlotAvailable(LocalTime slot, int duration, List<LocalTime> allTimeSlots) {
	    for (int i = 0; i < duration; i += 10) {
	        if (!allTimeSlots.contains(slot.plusMinutes(i))) {
	            return false;
	        }
	    }
	    return true;
	}
}