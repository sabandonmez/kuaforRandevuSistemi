package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.Worker;


public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
