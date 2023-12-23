package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.HairdresserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.hairdresser.CreateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.hairdresser.UpdateHairdresserRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetAllHairdressersResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.GetByIdHairdresserResponse;

@RestController
@RequestMapping("/api/hairdressers")
@AllArgsConstructor
public class HairdressersController {
	private HairdresserService hairdresserService;
	
	@GetMapping("/getAll")
	public List<GetAllHairdressersResponse> getAll(){
		return hairdresserService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateHairdresserRequest createHairdresserRequest) {
		this.hairdresserService.add(createHairdresserRequest);
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateHairdresserRequest updateHairdresserRequest) {
		this.hairdresserService.update(updateHairdresserRequest);
	}
	@GetMapping("/getByHairdresserId/{id}")
	public GetByIdHairdresserResponse getByHairdresserId(@PathVariable int id) {
	  return this.hairdresserService.getById(id);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.hairdresserService.delete(id);
	}

}
