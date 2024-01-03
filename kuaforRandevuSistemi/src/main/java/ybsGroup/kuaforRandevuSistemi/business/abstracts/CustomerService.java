package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;

public interface CustomerService {
	List<GetAllCustomerResponse> getAll();
	GetByIdCustomerResponse getById(int id);
	void add(CreateCustomerRequest createCustomerRequest);
	GetByIdCustomerResponse  getCustomerById(int id);
}
