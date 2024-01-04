package ybsGroup.kuaforRandevuSistemi.business.requests.worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkerRequest {
	private String firstName;
	private String lastName;
	private String password;
	private String phoneNumber;
	private String email;
	private Role role;
}
