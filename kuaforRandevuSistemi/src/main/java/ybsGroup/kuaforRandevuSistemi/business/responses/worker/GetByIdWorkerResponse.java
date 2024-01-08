package ybsGroup.kuaforRandevuSistemi.business.responses.worker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdWorkerResponse {
	private int workerId;
	private String firstName;
	private String lastName;
}
