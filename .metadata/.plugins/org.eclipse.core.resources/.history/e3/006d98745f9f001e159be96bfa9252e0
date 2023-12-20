package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Status;

@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private LocalDateTime dateTime;
	
	@ManyToOne
	@JoinColumn(name="employee_id" , referencedColumnName = "id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="customer_id" , referencedColumnName = "id")
	private User customer;
	
	@Enumerated(EnumType.STRING)
	private Status appointmentStatus;
	
	private String notes;
	
	@ManyToMany
	  @JoinTable(
		        name = "appointment_service",
		        joinColumns = @JoinColumn(name = "appointment_id"),
		        inverseJoinColumns = @JoinColumn(name = "service_id")
		    )
	private Set<Service> services = new HashSet<>();
	
	
	
	
	
}
