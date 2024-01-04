package ybsGroup.kuaforRandevuSistemi.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.CustomerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.CustomerRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Customer;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService{
	
	
	private final CustomerRepository customerRepository;
	private final ModelMapperService modelMapperService;
	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
	Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
	this.customerRepository.save(customer);
		
	}
	

}
