package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.UserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.UpdateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.user.CustomerRegisterRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.user.UserLoginRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.UpdateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetAllCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.customer.GetByIdCustomerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetAllWorkerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetByIdWorkerResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.exceptions.CustomerNotFoundException;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.UserRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void addCustomer(CreateCustomerRequest request) {
    	User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setRole(Role.CUSTOMER);
        userRepository.save(user);
    }

    @Override
    public List<GetAllCustomerResponse> getAllCustomers() {
        List<User> users = userRepository.findByRole(Role.CUSTOMER);
        return users.stream()
                    .map(user -> this.modelMapperService.forResponse().map(user, GetAllCustomerResponse.class))
                    .collect(Collectors.toList());
    }

    @Override
    public GetByIdCustomerResponse getByIdCustomer(int id) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
        if (user.getRole() != Role.CUSTOMER) {
            throw new CustomerNotFoundException("User with ID " + id + " is not a customer");
        }
        return this.modelMapperService.forResponse().map(user, GetByIdCustomerResponse.class);
    }

    @Override
    public void updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        User user = this.userRepository.findById(updateCustomerRequest.getCustomerId())
                                       .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + updateCustomerRequest.getCustomerId() + " not found"));
        if (updateCustomerRequest.getFirstName() != null) {
            user.setFirstName(updateCustomerRequest.getFirstName());
        }
        if (updateCustomerRequest.getLastName() != null) {
            user.setLastName(updateCustomerRequest.getLastName());
        }
        userRepository.save(user);
    }

    @Override
    public void deleteCustomer(int id) {
        if (!userRepository.existsById(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        this.userRepository.deleteById(id);
    }

	@Override
	public void addWorker(CreateWorkerRequest createWorkerRequest) {
		User user = new User();
        user.setFirstName(createWorkerRequest.getFirstName());
        user.setLastName(createWorkerRequest.getLastName());
        user.setPassword(createWorkerRequest.getPassword());
        user.setPhoneNumber(createWorkerRequest.getPhoneNumber());
        user.setEmail(createWorkerRequest.getEmail());
        user.setRole(Role.HAIRDRESSER);
        userRepository.save(user);	
	}

	@Override
	public List<GetAllWorkerResponse> getAllWorker() {
		List<User> users = userRepository.findByRole(Role.HAIRDRESSER);
        return users.stream()
                    .map(user -> this.modelMapperService.forResponse().map(user, GetAllWorkerResponse.class))
                    .collect(Collectors.toList());
	}

	@Override
	public GetByIdWorkerResponse getByIdWorker(int id) {
		 User user = userRepository.findById(id)
                 .orElseThrow(() -> new CustomerNotFoundException("Worker with ID " + id + " not found"));
		 if (user.getRole() != Role.HAIRDRESSER) {
			 throw new CustomerNotFoundException("User with ID " + id + " is not a worker");
		 }
		 return this.modelMapperService.forResponse().map(user, GetByIdWorkerResponse.class);
	}

	@Override
	public void updateWorker(UpdateWorkerRequest updateWorkerRequest) {
		 User user = this.userRepository.findById(updateWorkerRequest.getWorkerId())
                 .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + updateWorkerRequest.getWorkerId() + " not found"));
		 if (updateWorkerRequest.getFirstName() != null) {
			 user.setFirstName(updateWorkerRequest.getFirstName());
		 }
		 if (updateWorkerRequest.getLastName() != null) {
			 user.setLastName(updateWorkerRequest.getLastName());
		 }
		 userRepository.save(user);
		
	}

	@Override
	public void deleteWorker(int id) {
	     if (!userRepository.existsById(id)) {
	            throw new CustomerNotFoundException("Worker with ID " + id + " not found");
	        }
	        this.userRepository.deleteById(id);
	}

	@Override
	public void loginUser(UserLoginRequest userLoginRequest) {
	    if (userLoginRequest.getEmail() == null || userLoginRequest.getPassword() == null) {
	        throw new IllegalArgumentException("Email ve şifre boş olamaz");
	    }

	    User user = userRepository.findByEmail(userLoginRequest.getEmail());
	    if (user == null) {
	        throw new IllegalArgumentException("Kullanıcı bulunamadı");
	    }

	    if (!user.getPassword().equals(userLoginRequest.getPassword())) {
	        throw new IllegalArgumentException("Yanlış şifre");
	    }
	    String sessionKey = UUID.randomUUID().toString();
	    user.setSessionKey(sessionKey);
	    userRepository.save(user);
	}

	@Override
	public void customerRegister(CustomerRegisterRequest customerRegisterRequest) {
		 if (customerRegisterRequest.getFirstName() == null || customerRegisterRequest.getLastName() == null ||
				 customerRegisterRequest.getEmail() == null || customerRegisterRequest.getPhoneNumber() == null ||
						 customerRegisterRequest.getPassword() == null) {
			        throw new IllegalArgumentException("Kayıt için gerekli tüm alanlar doldurulmalıdır");
			 }
		 User existingUser = userRepository.findByEmail(customerRegisterRequest.getEmail());
		    if (existingUser != null) {
		        throw new IllegalStateException("Bu e-posta adresiyle zaten bir kullanıcı kayıtlı");
		    }
		    User newUser = new User();
		    newUser.setFirstName(customerRegisterRequest.getFirstName());
		    newUser.setLastName(customerRegisterRequest.getLastName());
		    newUser.setEmail(customerRegisterRequest.getEmail());
		    newUser.setPhoneNumber(customerRegisterRequest.getPhoneNumber());
		    newUser.setPassword(customerRegisterRequest.getPassword());
		    newUser.setRole(Role.CUSTOMER);
		    userRepository.save(newUser);
		
	}

}
