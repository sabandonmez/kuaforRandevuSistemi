package ybsGroup.kuaforRandevuSistemi.business.abstracts;

import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;

public interface WorkerService {
	void add(CreateWorkerRequest createWorkerRequest);
}
