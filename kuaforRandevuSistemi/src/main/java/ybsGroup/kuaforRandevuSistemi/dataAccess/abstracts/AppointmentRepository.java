package ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

	
	// Belirli bir tarih ve kuaför ID için mevcut randevuları bulan bir sorgu
	@Query("SELECT a FROM Appointment a WHERE a.hairdresser.id = :hairdresserId AND DATE(a.appointmentTime) = :date")	
	List<Appointment> findAllByHairdresserIdAndDate(int hairdresserId, LocalDate date);
	
}
