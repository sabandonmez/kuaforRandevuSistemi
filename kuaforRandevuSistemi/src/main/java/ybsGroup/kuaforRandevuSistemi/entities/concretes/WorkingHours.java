package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "workingHours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkingHours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id" , referencedColumnName = "id")
	private Employee employee;
	
	private String day;
	private LocalTime startTime;
	private LocalTime endTime;
}