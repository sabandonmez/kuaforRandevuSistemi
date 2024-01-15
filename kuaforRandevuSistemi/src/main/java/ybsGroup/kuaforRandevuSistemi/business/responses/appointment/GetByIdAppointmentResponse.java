package ybsGroup.kuaforRandevuSistemi.business.responses.appointment;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAppointmentResponse {
		private int workerId;
		private int customerId;
		private LocalDateTime appointmentDate;
		private List<Service> services;
}
