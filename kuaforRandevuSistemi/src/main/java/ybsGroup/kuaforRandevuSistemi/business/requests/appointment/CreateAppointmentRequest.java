package ybsGroup.kuaforRandevuSistemi.business.requests.appointment;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentRequest {
	private int hairdresserId;
	private int customerId;
	private List<Integer> servicesId;
	private LocalDateTime appointmentTime;
	private String customerNotes;
}
