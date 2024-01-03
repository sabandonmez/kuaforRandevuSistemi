package ybsGroup.kuaforRandevuSistemi.business.responses.hairdresser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdHairdresserResponse {
	private int id;
	private String firstName;
}
