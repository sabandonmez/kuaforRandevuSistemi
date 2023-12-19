package ybsGroup.kuaforRandevuSistemi.business.concretes;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ybsGroup.kuaforRandevuSistemi.business.abstracts.UserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.CreateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllUsersResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.UserRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public UserManager(UserRepository userRepository,ModelMapperService modelMapperService) {
		this.userRepository = userRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllUsersResponse> getAll() {
		
		List<User> users = userRepository.findAll();
		

		List<GetAllUsersResponse> usersResponse = users.stream().map(user->this.modelMapperService.forResponse()
					                         .map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
		
		return usersResponse;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {
		
		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		
		this.userRepository.save(user);
		
	}

}
