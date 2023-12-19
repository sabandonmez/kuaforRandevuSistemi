package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Table(name = "contactInfos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="phoneNumber" , nullable=false)
	private String phoneNumber;
	
	@Column(name="email" , nullable=false)
	private String email;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

}
