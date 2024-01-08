package ybsGroup.kuaforRandevuSistemi.business.responses.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllServicesResponse {

	private int serviceId;
	private String serviceName;
	private int duration;
	private double price;
}
