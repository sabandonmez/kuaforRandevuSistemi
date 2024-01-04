package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;

public interface CustomerService {
	void add(CreateCustomerRequest createCustomerRequest);
}
