package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
