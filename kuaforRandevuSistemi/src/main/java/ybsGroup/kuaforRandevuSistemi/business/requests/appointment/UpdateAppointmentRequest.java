package ybsGroup.kuaforRandevuSistemi.business.requests.appointment;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppointmentRequest {
	private int id;
	private int customerId;
	private int workerId;
	private LocalDateTime appointmentDate;
	private List<Integer> serviceIds;
	private String note;
}