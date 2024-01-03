package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.ServiceService;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.CreateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.UpdateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetAllServicesResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;

@Service
@AllArgsConstructor
public class ServiceManager implements ServiceService{
	
	private ServiceRepository serviceRepository;
	private ModelMapperService modelMapperService;
	


	@Override
	public List<GetAllServicesResponse> getAllServices() {
	    List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services = serviceRepository.findAll();
	    
	    List<GetAllServicesResponse> servicesResponse = services.stream()
	            .map(service -> {
	                GetAllServicesResponse response = modelMapperService.forResponse()
	                        .map(service, GetAllServicesResponse.class);
	                response.setId(service.getId()); 
	                return response;
	            })
	            .collect(Collectors.toList());
	    return servicesResponse;
	}



	@Override
	public void add(CreateServiceRequest createServiceRequest) {
		ybsGroup.kuaforRandevuSistemi.entities.concretes.Service service = this.modelMapperService.forRequest().map(createServiceRequest, ybsGroup.kuaforRandevuSistemi.entities.concretes.Service.class);
		this.serviceRepository.save(service);
	}

	@Override
	public void update(UpdateServiceRequest updateServiceRequest) {
		ybsGroup.kuaforRandevuSistemi.entities.concretes.Service service = this.serviceRepository.findById(updateServiceRequest.getId()).orElseThrow();
		service.setServiceName(updateServiceRequest.getServiceName());
		service.setDuration(updateServiceRequest.getDuration());
		service.setPrice(updateServiceRequest.getPrice());
		serviceRepository.save(service);
	}



	@Override
	public void delete(int id) {
		this.serviceRepository.deleteById(id);
		
	}
	
	

}