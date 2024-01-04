package ybsGroup.kuaforRandevuSistemi.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.ServiceService;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.CreateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;

@Service
@AllArgsConstructor
public class ServiceManager implements ServiceService{
	
	 private final ServiceRepository serviceRepository;
	  private final ModelMapperService modelMapperService;
	
	@Override
	public void add(CreateServiceRequest createServiceRequest) {
		ybsGroup.kuaforRandevuSistemi.entities.concretes.Service service = this.modelMapperService.forRequest().map(createServiceRequest, ybsGroup.kuaforRandevuSistemi.entities.concretes.Service.class);
		this.serviceRepository.save(service);
	}

}
