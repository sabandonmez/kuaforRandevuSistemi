package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.enums.Role;


@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "userName" , nullable=false , unique=true)
	private String userName;

	@Column(name = "password",nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role" , nullable=false)
	private Role role;

	@OneToOne(mappedBy = "user" ,cascade=CascadeType.ALL)
	@JoinColumn(name = "contact_info_id",referencedColumnName = "id")
	private ContactInfo contactInfo;
	
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private Employee employee;
	
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private Admin admin;
	

}