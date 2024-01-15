package ybsGroup.kuaforRandevuSistemi.business.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdResponse {
	private int customerId;
	private String firstName;
	private String lastName;
 	private String sessionKey;
    private Role role;
    private String phoneNumber;
    private String password;
}
