package ybsGroup.kuaforRandevuSistemi.business.rules;

import org.springframework.stereotype.Service;

import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.AppointmentRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;


@Service
public class AppointmentBusinessRules {
	private ServiceRepository serviceRepository;
	private AppointmentRepository appointmentRepository;
	
	public AppointmentBusinessRules(ServiceRepository serviceRepository,
			AppointmentRepository appointmentRepository) {
		this.serviceRepository = serviceRepository;
		this.appointmentRepository = appointmentRepository;
	}

//	public int calculateTotalDuration(List<Integer> servicesId) {
//		return servicesId.stream()
//				.mapToInt(serviceId -> {
//					ybsGroup.kuaforRandevuSistemi.entities.concretes.Service service =
//							this.serviceRepository.findById(serviceId).orElseThrow();
//					return service.getDuration();
//					}).sum();
//	}
//	
//	public List<LocalTime> findAvailableSlots(int hairdresserId , LocalDate date , int totalDuration){
//		
//		List<Appointment> appointments = appointmentRepository.findByHairdresserId(hairdresserId); //kuaförün mevcut randevularını dl den aldık.
//		
//		 List<Appointment> appointmentsForDay = appointments.stream()
//		        .filter(appointment -> appointment.getAppointmentTime().toLocalDate().equals(date))
//		        .sorted(Comparator.comparing(Appointment::getAppointmentTime)) // kuaförün randvularını getAppointmentTime 'a göre sıraladık.
//		        .collect(Collectors.toList());
//		
//		LocalTime startHour=BusinessHoursHelper.start_hour;
//		LocalTime endHour = BusinessHoursHelper.end_hour;
//		
//	
//		
//		List<LocalTime> availableSlots = new ArrayList<>();
//		LocalTime currentTime = startHour;
//		
//		for (Appointment appointment : appointmentsForDay) { //mevcut randevuarı geziyorum
//			LocalTime appointmentStart = appointment.getAppointmentTime().toLocalTime(); //randevunun başlangıç saati
//			
//			List<Integer> servicesId = appointment.getServices().stream()
//					.map(service -> service.getId())
//					.collect(Collectors.toList()); // appointment'ın servislerinin idleri aldım
//					
//			int appointmentDuration  = calculateTotalDuration(servicesId); // toplam süresi
//			LocalTime appointmentEnd = appointmentStart.plusMinutes(appointmentDuration); // başlangıç + duration = bitiş
//			while(currentTime.plusMinutes(totalDuration).isBefore(appointmentStart) || currentTime.equals(appointmentStart)) {
//				availableSlots.add(currentTime);
//				currentTime = currentTime.plusMinutes(10);
//			}
//			if (appointmentEnd.isAfter(currentTime)) {
//				currentTime = appointmentEnd;
//			}
//		}
//		
//		while(currentTime.plusMinutes(totalDuration).isBefore(endHour)) {
//			availableSlots.add(currentTime);
//			currentTime = currentTime.plusMinutes(10);
//		}
//			
//		return availableSlots;
//	}
	
	
}
