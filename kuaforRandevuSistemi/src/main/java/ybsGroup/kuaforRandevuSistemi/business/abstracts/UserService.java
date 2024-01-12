package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.UpdateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.UpdateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetAllWorkerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetByIdWorkerResponse;

public interface UserService {
	void addCustomer(CreateCustomerRequest request);
	List<GetAllCustomerResponse> getAllCustomers();
	GetByIdCustomerResponse getByIdCustomer(int id);
	void updateCustomer(UpdateCustomerRequest updateCustomerRequest);
	void deleteCustomer(int id);
	
	void addWorker(CreateWorkerRequest createWorkerRequest);
	List<GetAllWorkerResponse> getAllWorker();
	GetByIdWorkerResponse getByIdWorker(int id);
	void updateWorker(UpdateWorkerRequest updateWorkerRequest);
	void deleteWorker(int id);
}
