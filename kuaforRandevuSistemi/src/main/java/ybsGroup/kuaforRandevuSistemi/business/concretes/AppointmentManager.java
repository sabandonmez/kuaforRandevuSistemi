package ybsGroup.kuaforRandevuSistemi.business.concretes;


import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
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
    
}
