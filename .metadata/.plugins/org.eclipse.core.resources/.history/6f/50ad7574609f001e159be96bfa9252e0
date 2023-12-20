package ybsGroup.kuaforRandevuSistemi.entities.concretes;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serviceID")
	private int serviceID;
	
	@Column(name = "serviceName")
	private String serviceName;
	
	private int duration;
	
	@Column(name="price")
	private double price;
	
	@ManyToMany(mappedBy = "services")
	private Set<Appointment> appointments = new HashSet<>();
	
	

	
}
