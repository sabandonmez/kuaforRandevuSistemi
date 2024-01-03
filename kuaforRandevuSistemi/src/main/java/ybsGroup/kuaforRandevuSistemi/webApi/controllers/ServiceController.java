package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.ServiceService;
import ybsGroup.kuaforRandevuSistemi.business.requests.service.CreateServiceRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.service.GetAllServicesResponse;

@RestController
@RequestMapping("/api/services")
@AllArgsConstructor
@CrossOrigin
public class ServiceController {

	private ServiceService serviceService;
	
	@GetMapping("/getAllServices")
	public List<GetAllServicesResponse> getAllServices() {
		return serviceService.getAllServices();
	}
	
	@PostMapping("/addService")
	public void addService(CreateServiceRequest createServiceRequest) {
		serviceService.add(createServiceRequest);
	}
	
	@DeleteMapping("/deleteService")
	public void deleteService(int id) {
		serviceService.delete(id);
	}
}
