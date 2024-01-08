package ybsGroup.kuaforRandevuSistemi.business.requests.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateServiceRequest {
	
	private int serviceId;
	private String serviceName;
    private double price;
    private String note;
    private int duration;
}
