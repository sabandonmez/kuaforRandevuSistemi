package ybsGroup.kuaforRandevuSistemi.business.requests;

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
public class CreateHairdresserRequest {

	@NotNull
	@NotBlank
	@Size(min = 3)
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	@Size(min=6)
	private String password;
	private Role role;
	@NotNull
	@NotBlank
	private String phoneNumber;
	@NotNull
	@NotBlank
    private String email;
}