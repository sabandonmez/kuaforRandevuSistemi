package ybsGroup.kuaforRandevuSistemi.business.requests.worker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWorkerRequest {
	private int workerId;
	private String firstName;
	private String lastName;
    private String password;
    private String phoneNumber;
}
