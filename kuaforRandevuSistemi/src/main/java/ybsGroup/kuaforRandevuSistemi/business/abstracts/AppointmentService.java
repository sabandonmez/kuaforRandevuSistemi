package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;

public interface AppointmentService {
	void add(CreateAppointmentRequest createAppointmentRequest);
}
