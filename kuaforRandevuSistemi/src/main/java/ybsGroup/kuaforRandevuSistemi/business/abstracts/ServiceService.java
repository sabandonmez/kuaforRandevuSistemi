package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.service.CreateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.UpdateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetAllServicesResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetByIdServiceResponse;

public interface ServiceService {
	 void add(CreateServiceRequest createServiceRequest);
	 void update(UpdateServiceRequest updateServiceRequest);
	 void delete(int id);
	 List<GetAllServicesResponse> getAllServices();
	 GetByIdServiceResponse getById(int id);
}
