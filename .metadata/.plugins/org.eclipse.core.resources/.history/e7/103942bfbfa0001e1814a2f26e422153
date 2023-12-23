package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ybsGroup.kuaforRandevuSistemi.business.abstracts.UserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.CreateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.UpdateUserProfileRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.UpdateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllUsersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetByIdUserResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.UserRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserRepository userRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public UserManager(UserRepository userRepository, ModelMapperService modelMapperService) {
		this.userRepository = userRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllUsersResponse> getAll() {

		List<User> users = userRepository.findAll();

		List<GetAllUsersResponse> usersResponse = users.stream()
				.map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
				.collect(Collectors.toList());

		return usersResponse;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {

		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);

		this.userRepository.save(user);
	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		User user = this.userRepository.findById(updateUserRequest.getId()).orElseThrow();
		if (user.getFirstName() != null) {
			user.setFirstName(updateUserRequest.getFirstName());
		}
		if (user.getLastName() != null) {
			user.setLastName(updateUserRequest.getLastName());
		}
		if (user.getRole() != null) {
			user.setRole(updateUserRequest.getRole());
		}
		userRepository.save(user);

	}

	@Override
	public GetByIdUserResponse getById(int id) {
		User user = this.userRepository.findById(id).orElseThrow();
		GetByIdUserResponse response = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);

		return response;
	}

	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);
		;

	}

	@Override
	public void updateUserProfile(UpdateUserProfileRequest updateUserProfileRequest) {
		User user = this.userRepository.findById(updateUserProfileRequest.getId()).orElseThrow();
		
		if (updateUserProfileRequest.getFirstName()!=null) {
			user.setFirstName(updateUserProfileRequest.getFirstName());
		}
		if (updateUserProfileRequest.getLastName()!=null) {
			user.setLastName(updateUserProfileRequest.getLastName());
		}
		if (updateUserProfileRequest.getEmail()!=null) {
			user.setEmail(updateUserProfileRequest.getEmail());
		}
		if (updateUserProfileRequest.getPhoneNumber()!=null) {
			user.setPhoneNumber(updateUserProfileRequest.getPhoneNumber());
		}
		if (updateUserProfileRequest.getPassword()!=null) {
			user.setPassword(updateUserProfileRequest.getPassword());
		}
		this.userRepository.save(user);
	}

}
