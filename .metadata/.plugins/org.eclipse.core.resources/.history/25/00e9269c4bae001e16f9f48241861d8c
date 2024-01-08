package ybsGroup.kuaforRandevuSistemi.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.WorkerService;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;
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

}
