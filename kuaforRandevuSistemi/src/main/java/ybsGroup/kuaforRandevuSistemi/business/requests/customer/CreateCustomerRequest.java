package ybsGroup.kuaforRandevuSistemi.business.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

	private String firstName;
	private String lastName;
	private String password;
	private Role role;
	private String phoneNumber;
    private String email;
}
