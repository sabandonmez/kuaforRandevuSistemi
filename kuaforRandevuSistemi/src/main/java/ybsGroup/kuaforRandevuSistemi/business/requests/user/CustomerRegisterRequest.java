package ybsGroup.kuaforRandevuSistemi.business.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequest {
	private String firstName;
	private String lastName;
	 private String email;
	 private String phoneNumber;
	 private String password;
	 private Role role;
}
