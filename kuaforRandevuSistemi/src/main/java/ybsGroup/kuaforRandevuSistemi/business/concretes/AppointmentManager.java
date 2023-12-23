package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.rules.AppointmentBusinessRules;
import ybsGroup.kuaforRandevuSistemi.core.utilities.exceptions.AvailableSlotsNotContainsRequestTimeException;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.AppointmentRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.CustomerRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.HairdresserRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Customer;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Hairdresser;

@Service
public class AppointmentManager implements AppointmentService{

	private AppointmentRepository appointmentRepository;
	private CustomerRepository customerRepository;
	private HairdresserRepository hairdresserRepository;
	private ServiceRepository serviceRepository;
	private AppointmentBusinessRules appointmentBusinessRules;
	
	


	public AppointmentManager(AppointmentRepository appointmentRepository, CustomerRepository customerRepository,
			HairdresserRepository hairdresserRepository,AppointmentBusinessRules appointmentBusinessRules) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.customerRepository = customerRepository;
		this.hairdresserRepository = hairdresserRepository;
		this.appointmentBusinessRules=appointmentBusinessRules;
	}




	@Override
	public void add(CreateAppointmentRequest createAppointmentRequest) {
		//müsaitlik
		List<LocalTime> availableSlots = appointmentBusinessRules.findAvailableSlots(
										createAppointmentRequest.getHairdresserId(),
										createAppointmentRequest.getAppointmentTime().toLocalDate(),
										appointmentBusinessRules.calculateTotalDuration(createAppointmentRequest.getServicesId())
										);				
		LocalTime requestedTime = createAppointmentRequest.getAppointmentTime().toLocalTime();
		if (!availableSlots.contains(requestedTime)) {
			throw new AvailableSlotsNotContainsRequestTimeException("The requested appointment time is not available. "
					+ "Please choose a different time or check available slots.");
		}
		
		Appointment appointment = new Appointment();
		Customer customer = customerRepository.findById(createAppointmentRequest.getCustomerId()).orElseThrow();
		Hairdresser hairdresser = hairdresserRepository.findById(createAppointmentRequest.getHairdresserId()).orElseThrow();
		
		appointment.setCustomer(customer);
		appointment.setHairdresser(hairdresser);
		
		Set<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services = createAppointmentRequest.getServicesId().stream()
				.map(serviceId -> serviceRepository.findById(serviceId).orElseThrow())
				.collect(Collectors.toSet());
		
		appointment.setServices(services);
		appointment.setAppointmentTime(createAppointmentRequest.getAppointmentTime());
		appointment.setNotes(createAppointmentRequest.getCustomerNotes());
		
		this.appointmentRepository.save(appointment);
	}
	
	
	
}
