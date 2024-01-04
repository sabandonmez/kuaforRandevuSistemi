package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
}
