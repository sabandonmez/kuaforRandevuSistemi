package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Service;


public interface ServiceRepository extends JpaRepository<Service,Integer>{

}