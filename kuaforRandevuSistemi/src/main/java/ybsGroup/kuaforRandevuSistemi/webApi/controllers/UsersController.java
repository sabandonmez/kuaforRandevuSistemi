package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.UserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.CreateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllUsersResponse;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

	    @Autowired
		private UserService userService;
		
		@GetMapping()
		public List<GetAllUsersResponse> getAll(){
			return userService.getAll();
		}
		
		@PostMapping()
		@ResponseStatus(code = HttpStatus.CREATED)
		public void add(@RequestBody() CreateUserRequest createUserRequest) {
			this.userService.add(createUserRequest);
		}
}