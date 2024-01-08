package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.CustomerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.UpdateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public void add(CreateCustomerRequest createCustomerRequest) {
		this.customerService.add(createCustomerRequest);
	}
	
	@GetMapping("/get-all-customers")
	public List<GetAllCustomerResponse> getAll(){
		return customerService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdCustomerResponse getById(@PathVariable int id) {
		return customerService.getById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
		this.customerService.update(updateCustomerRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.customerService.delete(id);
	}
	
	
}
