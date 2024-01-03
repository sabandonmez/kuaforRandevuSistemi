package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hairdressers")
public class Hairdresser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "password")
	private String password;
	
	@Column(name="phoneNumber" )
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "hairdresser")
	private Set<Appointment> appointments = new HashSet<>();
	
}
