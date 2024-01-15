package ybsGroup.kuaforRandevuSistemi.business.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
	private int customerId;
	private String firstName;
	private String lastName;
    private String password;
    private String phoneNumber;
}
