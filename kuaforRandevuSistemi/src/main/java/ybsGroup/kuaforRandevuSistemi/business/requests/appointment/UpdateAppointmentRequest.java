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
	private String customerId;
	private String workerId;
	private LocalDateTime appointmentDate;
	private List<Integer> serviceIds;
	private String note;
}
