package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.HairdresserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.CreateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllHairdressersResponse;

@RestController
@RequestMapping("/api/hairdressers")
@AllArgsConstructor
public class HairdressersController {
	private HairdresserService hairdresserService;
	
	@GetMapping()
	public List<GetAllHairdressersResponse> getAll(){
		return hairdresserService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateHairdresserRequest createHairdresserRequest) {
		this.hairdresserService.add(createHairdresserRequest);
	}

}