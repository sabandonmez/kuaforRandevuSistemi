package ybsGroup.kuaforRandevuSistemi.business.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {
	private int userId;
	private String firstName;
	private String lastName;
	private String token;
}
