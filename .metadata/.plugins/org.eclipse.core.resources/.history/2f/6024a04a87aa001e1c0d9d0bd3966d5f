package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.user.UpdateUserProfileRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.user.UpdateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.user.GetAllUsersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.user.GetByIdUserResponse;


public interface UserService {
	List<GetAllUsersResponse> getAll();
	GetByIdUserResponse getById(int id);
//	void add(CreateUserRequest createUserRequest);
	void update(UpdateUserRequest updateUserRequest);
	void delete(int id);
	void updateUserProfile(UpdateUserProfileRequest updateUserProfileRequest);
	boolean login(String email,String password);
}
