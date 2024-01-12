package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

public interface UserRepository extends JpaRepository<User,Integer>{
	List<User> findByRole(Role role);
}
