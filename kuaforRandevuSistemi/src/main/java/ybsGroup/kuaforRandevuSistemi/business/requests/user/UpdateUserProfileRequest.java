package ybsGroup.kuaforRandevuSistemi.business.requests.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserProfileRequest {
	
	private int id;
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 10,max = 11)
	private String phoneNumber;
	@NotNull
	@NotBlank
	@Size(min=6)
	private String password;
}
