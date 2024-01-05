package ybsGroup.kuaforRandevuSistemi.business.rules;

import org.springframework.stereotype.Service;

import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.AppointmentRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;


@Service
public class AppointmentBusinessRules {
	private ServiceRepository serviceRepository;
	private AppointmentRepository appointmentRepository;
	
	public AppointmentBusinessRules(ServiceRepository serviceRepository,
			AppointmentRepository appointmentRepository) {
		this.serviceRepository = serviceRepository;
		this.appointmentRepository = appointmentRepository;
	}
	
	
}
