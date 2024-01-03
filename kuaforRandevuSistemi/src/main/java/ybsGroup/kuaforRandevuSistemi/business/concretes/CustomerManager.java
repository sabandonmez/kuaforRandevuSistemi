package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.CustomerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.CustomerRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Customer;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService{
	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCustomerResponse> getAll() {
		List<Customer> customers = customerRepository.findAll();
		List<GetAllCustomerResponse> customersResponse = customers.stream().map(
				customer -> this.modelMapperService.forResponse().map(customer, GetAllCustomerResponse.class))
				.collect(Collectors.toList());
		return customersResponse;
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		customer.setRole(Role.CUSTOMER);
		this.customerRepository.save(customer);
		
	}

	@Override
	public GetByIdCustomerResponse getById(int id) {
		Customer customer = customerRepository.findById(id).orElseThrow();
		GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer,GetByIdCustomerResponse.class);
		return response;
	}

	@Override
	public GetByIdCustomerResponse getCustomerById(int id) {
		Customer customer = customerRepository.getCustomerById(id);
		GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer,GetByIdCustomerResponse.class);
		return response;
	}

}