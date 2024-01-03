package ybsGroup.kuaforRandevuSistemi.business.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
	private String email;
	private String password;
}
