package ybsGroup.kuaforRandevuSistemi.business.responses.appointment;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetAllServicesResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAppointmentsResponse {
	private String appointmentId;
	private GetAllCustomerResponse customer;
	private GetAllCustomerResponse employee;
	private LocalDateTime appointmentDate;
	private List<GetAllServicesResponse> services;
	private String note;
}
