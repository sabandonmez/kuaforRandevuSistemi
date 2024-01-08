package ybsGroup.kuaforRandevuSistemi.business.responses.worker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWorkerResponse {
	private String workerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
}
