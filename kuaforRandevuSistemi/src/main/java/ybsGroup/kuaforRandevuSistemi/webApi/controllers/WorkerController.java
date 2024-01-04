package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.WorkerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;

@RestController
@RequestMapping("/api/workers")
@AllArgsConstructor
@CrossOrigin
public class WorkerController {
	
	private WorkerService workerService;
	
	@PostMapping("/addWorker")
	public void add(CreateWorkerRequest createWorkerRequest) {
		this.workerService.add(createWorkerRequest);
	}
}
