package ybsGroup.kuaforRandevuSistemi.business.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {
	private int id;
	private String firstName;
	private String sessionKey;
    private Role role;
}
