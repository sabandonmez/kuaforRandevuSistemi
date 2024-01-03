package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.service.CreateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.UpdateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetAllServicesResponse;

public interface ServiceService {
	List<GetAllServicesResponse> getAllServices();
	void add(CreateServiceRequest createServiceRequest);
	void update(UpdateServiceRequest updateServiceRequest);
	void delete(int id);
}