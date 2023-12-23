package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.HairdresserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.hairdresser.CreateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.hairdresser.UpdateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllHairdressersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetByIdHairdresserResponse;
import ybsGroup.kuaforRandevuSistemi.business.rules.HairdresserBusinessRules;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.HairdresserRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Hairdresser;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Service
@AllArgsConstructor
public class HairdresserManager implements HairdresserService {
	private HairdresserRepository hairdresserRepository;
	private ModelMapperService modelMapperService;
	private HairdresserBusinessRules hairdresserBusinessRules;

	@Override
	public List<GetAllHairdressersResponse> getAll() {
		List<Hairdresser> hairdressers = hairdresserRepository.findAll();

		List<GetAllHairdressersResponse> hairdressersResponse = hairdressers.stream().map(
				hairdresser -> this.modelMapperService.forResponse().map(hairdresser, GetAllHairdressersResponse.class))
				.collect(Collectors.toList());

		return hairdressersResponse;
	}

	@Override
	public void add(CreateHairdresserRequest createHairdresserRequest) {
		this.hairdresserBusinessRules.checkIfHairdresserEmailExists(createHairdresserRequest.getEmail());

		Hairdresser hairdresser = this.modelMapperService.forRequest().map(createHairdresserRequest, Hairdresser.class);
		hairdresser.setRole(Role.HAIRDRESSER);
		this.hairdresserRepository.save(hairdresser);

	}

	@Override
	public GetByIdHairdresserResponse getById(int id) {
		Hairdresser hairdresser = this.hairdresserRepository.findById(id).orElseThrow();
		GetByIdHairdresserResponse response = this.modelMapperService.forResponse().map(hairdresser,GetByIdHairdresserResponse.class);
		return response;
	}

	@Override
	public void update(UpdateHairdresserRequest updateHairdresserRequest) {
		Hairdresser hairdresser = this.hairdresserRepository.findById(updateHairdresserRequest.getId()).orElseThrow();
		if (hairdresser.getFirstName() != null) {
			hairdresser.setFirstName(updateHairdresserRequest.getFirstName());
		}
		if (hairdresser.getLastName() != null) {
			hairdresser.setLastName(updateHairdresserRequest.getLastName());
		}
		this.hairdresserRepository.save(hairdresser);
	
	}

	@Override
	public void delete(int id) {
		this.hairdresserRepository.deleteById(id);
	}

}
