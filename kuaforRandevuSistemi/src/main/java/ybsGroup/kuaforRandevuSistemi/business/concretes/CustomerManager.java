package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.CustomerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.UpdateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.exceptions.CustomerNotFoundException;
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
	@Override
	public List<GetAllCustomerResponse> getAll() {
		List<Customer> customers = customerRepository.findAll();
		List<GetAllCustomerResponse> customersResponse = customers.stream().map(
				customer -> this.modelMapperService.forResponse().map(customer, GetAllCustomerResponse.class))
				.collect(Collectors.toList());
		return customersResponse;
	}
	@Override
	public GetByIdCustomerResponse getById(int id) {
		Customer customer = customerRepository.findById(id).orElseThrow();
		GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer,GetByIdCustomerResponse.class);
		return response;
	}
	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		  Customer customer = this.customerRepository.findById(updateCustomerRequest.getCustomerId()).orElseThrow();
		    if (customer == null) {
		        throw new CustomerNotFoundException("Customer with ID " + updateCustomerRequest.getCustomerId() + " not found");
		    }
		    if (updateCustomerRequest.getFirstName() != null) {
		        customer.setFirstName(updateCustomerRequest.getFirstName());
		    }
		    if (updateCustomerRequest.getLastName() != null) {
		        customer.setLastName(updateCustomerRequest.getLastName());
		    }
		    customerRepository.save(customer);
		
	}
	@Override
	public void delete(int id) {
		this.customerRepository.deleteById(id);
		
	}
	

}
