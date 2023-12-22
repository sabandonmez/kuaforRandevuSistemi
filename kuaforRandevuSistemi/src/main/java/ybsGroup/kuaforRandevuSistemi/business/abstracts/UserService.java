package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.CreateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.UpdateUserProfileRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.UpdateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllUsersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetByIdUserResponse;


public interface UserService {
	List<GetAllUsersResponse> getAll();
	GetByIdUserResponse getById(int id);
	void add(CreateUserRequest createUserRequest);
	void update(UpdateUserRequest updateUserRequest);
	void delete(int id);
	void updateUserProfile(UpdateUserProfileRequest updateUserProfileRequest);
}
