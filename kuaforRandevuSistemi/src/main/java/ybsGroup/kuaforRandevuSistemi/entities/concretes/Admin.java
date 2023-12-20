package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin extends User {
	
	public Admin(int id, String firstName, String lastName, String password, String phoneNumber, String email,
			Role role) {
		super(id, firstName, lastName, password, phoneNumber, email, role);
	
	}
	
}
