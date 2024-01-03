package ybsGroup.kuaforRandevuSistemi.business.requests.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceRequest {
	@NotNull
	@NotBlank
	private String serviceName;
	@NotNull
	@NotBlank
	private int duration;
	@NotNull
	@NotBlank
	private double price;
}
