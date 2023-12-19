package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.WorkingHours;

public interface WorkingHourRepository extends JpaRepository<WorkingHours,Integer>{

}
