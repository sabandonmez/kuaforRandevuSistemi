package ybsGroup.kuaforRandevuSistemi.entities.concretes;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "service_id")
	private int id;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "service_duration")
	private int duration;
	@Column(name = "service_price")
	private double price;


}
