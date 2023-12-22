package ybsGroup.kuaforRandevuSistemi.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHairdresserRequest {

	private int id;
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String firstName;
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String lastName;
	
	
}
