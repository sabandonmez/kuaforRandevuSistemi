package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
}