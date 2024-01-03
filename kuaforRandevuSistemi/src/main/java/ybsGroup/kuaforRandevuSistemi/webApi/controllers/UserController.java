package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.UserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.user.LoginRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.user.UpdateUserProfileRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.user.UpdateUserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.user.GetAllUsersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.user.GetByIdUserResponse;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {

	    @Autowired
		private UserService userService;
		
		@GetMapping()
		public List<GetAllUsersResponse> getAll(){
			return userService.getAll();
		}
		@GetMapping("/{id}")
		public GetByIdUserResponse getByUserId(@PathVariable int id) {
			return userService.getById(id);
		}
		
//		@PostMapping()
//		@ResponseStatus(code = HttpStatus.CREATED)
//		public void add(@RequestBody() CreateUserRequest createUserRequest) {
//			this.userService.add(createUserRequest);
//		}
		
		@PutMapping("/update")
		public void update(@RequestBody UpdateUserRequest updateUserRequest) {
			this.userService.update(updateUserRequest);
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable int id) {
			this.userService.delete(id);
		}
		
		@PutMapping("/updateUserProfile")
		public void updateUserProfile(@RequestBody UpdateUserProfileRequest updateUserProfileRequest) {
			this.userService.updateUserProfile(updateUserProfileRequest);
		}
		 @PostMapping("/login")
		    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		        boolean isLoginSuccessful = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

		        if (isLoginSuccessful) {
		            return ResponseEntity.ok("Giriş başarılı.");
		        } else {
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Giriş başarısız: Kullanıcı adı veya parola yanlış.");
		        }
		    }
}



















