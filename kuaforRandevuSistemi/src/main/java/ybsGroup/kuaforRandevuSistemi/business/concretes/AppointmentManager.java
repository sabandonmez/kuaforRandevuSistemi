package ybsGroup.kuaforRandevuSistemi.business.concretes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.AppointmentRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.CustomerRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.HairdresserRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Customer;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Hairdresser;

@Service
@AllArgsConstructor
public class AppointmentManager implements AppointmentService{

	private AppointmentRepository appointmentRepository;
	private CustomerRepository customerRepository;
	private HairdresserRepository hairdresserRepository;
	private ServiceRepository serviceRepository;

	@Override
	   public void createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        // Müşteri ve kuaför bilgilerini bul
		
		Customer customer = customerRepository.getCustomerById(createAppointmentRequest.getCustomerId());
        Hairdresser hairdresser = hairdresserRepository.getHairdresserById(createAppointmentRequest.getHairdresserId());

        // Seçilen hizmetleri bul
        Set<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services = createAppointmentRequest.getServicesId().stream()
                .map(serviceId -> serviceRepository.findById(serviceId)
                        .orElseThrow(() -> new RuntimeException("Hizmet bulunamadı: " + serviceId)))
                .collect(Collectors.toSet());

        // Yeni randevu oluştur
        Appointment appointment = new Appointment();
        appointment.setCustomer(customer);
        appointment.setHairdresser(hairdresser);
        appointment.setServices(services);
        appointment.setAppointmentDate(createAppointmentRequest.getAppointmentDate());
        appointment.setAppointmentTime(createAppointmentRequest.getAppointmentTime());
        appointment.setNotes(createAppointmentRequest.getNotes());

        // Randevuyu veritabanına kaydet
        appointmentRepository.save(appointment);
    }


//
//	@Override
//	public List<GetAllAppointmentsResponse> getAllAppointmentByRole(Role role,int userId) {
//		List<Appointment> appointments ;
//		
//		if (role==Role.ADMIN) {
//			appointments = appointmentRepository.findAll();	
//		}
//		else if(role==Role.CUSTOMER)
//		{
//			appointments = appointmentRepository.findByCustomerId(userId);
//		}
//		else {
//			appointments = appointmentRepository.findByHairdresserId(userId);
//		}
//		return appointments.stream().map(this::convertToResponse).collect(Collectors.toList());
//	}
//	
//	@Override
//	private GetAllAppointmentsResponse convertToResponse(Appointment appointment) {
//		GetAllAppointmentsResponse response = new GetAllAppointmentsResponse();
//		response.setHairdresserName(appointment.getHairdresser().getFirstName()+" "+appointment.getHairdresser().getLastName());
//		response.setCustomerName(appointment.getCustomer().getFirstName()+" "+appointment.getCustomer().getLastName());
//		response.setServicesName(appointment.getServices().stream()
//                .map(ybsGroup.kuaforRandevuSistemi.entities.concretes.Service::getServiceName)
//                .collect(Collectors.toList()));
//		response.setAppointmentTime(appointment.getAppointmentTime());
//		response.setAppointmentDate(appointment.getAppointmentDate());
//		response.setNotes(appointment.getNotes());
//		return response;
//	}

	@Override
	public List<LocalTime> findAvailableSlots(int hairdresserId, LocalDate date, int totalDuration) {
	    LocalTime startTime = LocalTime.of(9, 0); // İş gününün başlangıcı
	    LocalTime endTime = LocalTime.of(21, 0); // İş gününün sonu
	    List<LocalTime> allTimeSlots = new ArrayList<>();

	    // Tüm zaman dilimlerini oluştur
	    while (startTime.isBefore(endTime)) {
	        allTimeSlots.add(startTime);
	        startTime = startTime.plusMinutes(totalDuration);
	    }

	    // Belirli bir tarihte kuaföre ait mevcut randevuları al
	    List<Appointment> appointments = appointmentRepository.findAllByHairdresserIdAndDate(hairdresserId, date);

	    // Mevcut randevu zamanlarını çıkararak boş zaman dilimlerini bul
	    Set<LocalTime> bookedSlots = appointments.stream()
	            .map(appointment -> appointment.getAppointmentTime()) 
	            .collect(Collectors.toSet());
	    allTimeSlots.removeIf(bookedSlots::contains);

	    return allTimeSlots;
	}






	
	
}
