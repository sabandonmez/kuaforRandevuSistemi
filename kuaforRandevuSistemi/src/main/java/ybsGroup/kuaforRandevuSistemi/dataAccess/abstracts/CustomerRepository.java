package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer getCustomerById(int id);  
}
