package ybsGroup.kuaforRandevuSistemi.business.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
}
