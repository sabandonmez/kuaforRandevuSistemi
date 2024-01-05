package ybsGroup.kuaforRandevuSistemi.business.responses.appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAppointmentsResponse {
	private int id;
	private String customerId;
	private String workerId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private List<Integer> serviceIds;
	private String note;
}
