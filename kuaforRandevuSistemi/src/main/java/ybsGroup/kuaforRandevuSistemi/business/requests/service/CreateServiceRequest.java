package ybsGroup.kuaforRandevuSistemi.business.requests.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceRequest {

	private String serviceName;
	private int duration;
	private double price;
}
