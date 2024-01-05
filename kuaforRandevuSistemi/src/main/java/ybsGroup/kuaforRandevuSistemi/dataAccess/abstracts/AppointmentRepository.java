package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	List<Appointment> findAllByWorkerIdAndAppointmentDate(int workerId,LocalDate appointmentDate);
}
