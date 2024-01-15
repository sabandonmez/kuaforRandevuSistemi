package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.ServiceService;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.CreateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.UpdateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetAllServicesResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetByIdServiceResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.ServiceTotalDurationAndPriceResponse;

@RestController
@RequestMapping("/api/services")
@AllArgsConstructor
@CrossOrigin
public class ServiceController {
	@Autowired
	private ServiceService serviceService;
	@PostMapping("/addService")
	public void add(CreateServiceRequest createServiceRequest) {
		this.serviceService.add(createServiceRequest);
	}
	
	@GetMapping("/get-all-services")
	public List<GetAllServicesResponse> getAllServices() {
		return serviceService.getAllServices();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.serviceService.delete(id);
	}
	
	@PutMapping("/update-service")
	public void update(UpdateServiceRequest updateServiceRequest) {
		this.serviceService.update(updateServiceRequest);
	}
	
	@GetMapping("/get-by-id-service")
	public GetByIdServiceResponse getById(int id) {
		return this.serviceService.getById(id);
	}
	
	
	

	
	
}
