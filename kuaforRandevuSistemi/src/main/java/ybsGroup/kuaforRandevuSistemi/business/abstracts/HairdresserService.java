package ybsGroup.kuaforRandevuSistemi.business.abstracts;
import java.util.List;

import ybsGroup.kuaforRandevuSistemi.business.requests.CreateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.UpdateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllHairdressersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetByIdHairdresserResponse;

public interface HairdresserService {
	List<GetAllHairdressersResponse> getAll();
	GetByIdHairdresserResponse getById(int id);
	void add(CreateHairdresserRequest createHairdresserRequest);
	void update(UpdateHairdresserRequest updateHairdresserRequest);
	void delete(int id);
}
