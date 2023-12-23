package ybsGroup.kuaforRandevuSistemi.business.requests.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
	private int id;
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String firstName;
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String lastName;
	private Role role;
}
