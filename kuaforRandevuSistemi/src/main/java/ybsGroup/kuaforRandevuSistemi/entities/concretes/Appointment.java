package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int id;
	
	
	@Column(name = "appointment_date")
	private LocalDateTime appointmentDate;
	
	@Column(name = "note")
	private String note;

	@ManyToOne
    @JoinColumn(name = "customer_id") // Burada 'customer_id' kullanılıyor
    private User customer;

    @ManyToOne
    @JoinColumn(name = "worker_id") // Farklı bir sütun adı kullanılıyor
    private User worker;

	
	@ManyToMany
	@JoinTable(name = "appointments_services",
			joinColumns = @JoinColumn(name = "appointment_id"),
			inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<Service> services;
	
}