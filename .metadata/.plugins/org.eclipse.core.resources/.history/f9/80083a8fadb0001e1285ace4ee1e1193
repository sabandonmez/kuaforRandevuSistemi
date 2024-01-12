package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.WorkerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.UpdateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetAllWorkerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetByIdWorkerResponse;

@RestController
@RequestMapping("/api/workers")
@AllArgsConstructor
@CrossOrigin
public class WorkerController {
	@Autowired
	private WorkerService workerService;
	
	@PostMapping("/addWorker")
	public void add(CreateWorkerRequest createWorkerRequest) {
		this.workerService.add(createWorkerRequest);
	}
	
	@GetMapping("/get-all-workers")
	public List<GetAllWorkerResponse> getAll(){
		return workerService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdWorkerResponse getById(@PathVariable int id) {
		return workerService.getById(id);
	}
	
	@PutMapping("/update-worker")
	public void update(@RequestBody UpdateWorkerRequest updateWorkerRequest) {
		this.workerService.update(updateWorkerRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.workerService.delete(id);
	}
	
}
