package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);
}
