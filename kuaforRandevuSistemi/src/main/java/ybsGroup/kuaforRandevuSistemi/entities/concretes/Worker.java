package ybsGroup.kuaforRandevuSistemi.entities.concretes;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;
@Table(name="workers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worker_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;
	
	@Column(name="phone_number" )
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "worker")
	@JsonIgnore
	private List<Appointment> appointments;

//	@OneToMany(mappedBy = "worker")
//	@JsonIgnore
//	private List<Service> services;
}
