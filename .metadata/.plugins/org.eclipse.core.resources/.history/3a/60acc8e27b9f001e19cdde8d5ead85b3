package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
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
public class Hairdresser extends User {

	public Hairdresser(int id, String firstName, String lastName, String password, String phoneNumber, String email,
			Role role) {
		super(id, firstName, lastName, password, phoneNumber, email, role);
	}

	@OneToMany(mappedBy = "hairdresser")
	private Set<Appointment> appointments = new HashSet<>();
}
