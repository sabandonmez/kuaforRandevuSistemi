package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.WorkerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.UpdateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetAllWorkerResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.worker.GetByIdWorkerResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.exceptions.CustomerNotFoundException;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.WorkerRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Worker;

@Service
@AllArgsConstructor
public class WorkerManager implements WorkerService {
	private WorkerRepository workerRepository;
	private ModelMapperService modelMapperService;
	@Override
	public void add(CreateWorkerRequest createWorkerRequest) {
		Worker worker = this.modelMapperService.forRequest().map(createWorkerRequest, Worker.class);
		this.workerRepository.save(worker);
		
	}
	@Override
	public List<GetAllWorkerResponse> getAll() {
		List<Worker> workers = workerRepository.findAll();
		List<GetAllWorkerResponse> workersResponse = workers.stream().map(
				worker -> this.modelMapperService.forResponse().map(worker, GetAllWorkerResponse.class))
				.collect(Collectors.toList());
		return workersResponse;
	}
	@Override
	public GetByIdWorkerResponse getById(int id) {
		Worker worker = workerRepository.findById(id).orElseThrow();
		GetByIdWorkerResponse response = this.modelMapperService.forResponse().map(worker,GetByIdWorkerResponse.class);
		return response;
	}
	@Override
	public void update(UpdateWorkerRequest updateWorkerRequest) {
		Worker worker = this.workerRepository.findById(updateWorkerRequest.getWorkerId()).orElseThrow(() -> new CustomerNotFoundException("Worker Not Found"));
		if (worker.getFirstName() != null) {
			worker.setFirstName(updateWorkerRequest.getFirstName());
		}
		if (worker.getLastName() != null) {
			worker.setLastName(updateWorkerRequest.getLastName());
		}
		if (worker.getRole() != null) {
			worker.setRole(updateWorkerRequest.getRole());
		}
		workerRepository.save(worker);
		
	}
	@Override
	public void delete(int id) {
		this.workerRepository.deleteById(id);
		
	}

}
