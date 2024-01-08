package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.CustomerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
	private CustomerService customerService;
	@PostMapping("/addCustomer")
	public void add(CreateCustomerRequest createCustomerRequest) {
		this.customerService.add(createCustomerRequest);
	}
}
