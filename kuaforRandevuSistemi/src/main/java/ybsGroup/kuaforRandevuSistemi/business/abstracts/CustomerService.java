package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.UpdateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;

public interface CustomerService {
	void add(CreateCustomerRequest createCustomerRequest);
	List<GetAllCustomerResponse> getAll();
	GetByIdCustomerResponse getById(int id);
	void update(UpdateCustomerRequest updateCustomerRequest);
	void delete(int id);
}
