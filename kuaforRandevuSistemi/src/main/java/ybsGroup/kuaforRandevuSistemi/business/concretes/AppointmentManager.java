package ybsGroup.kuaforRandevuSistemi.business.concretes;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.AppointmentService;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.CreateAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.appointment.DeleteAppointmentRequest;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetAllAppointmentsResponse;
import ybsGroup.kuaforRandevuSistemi.business.responses.appointment.GetByIdAppointmentResponse;
import ybsGroup.kuaforRandevuSistemi.core.utilities.mappers.ModelMapperService;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.AppointmentRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.ServiceRepository;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.UserRepository;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.Appointment;
import ybsGroup.kuaforRandevuSistemi.entities.concretes.User;

@Service
@AllArgsConstructor
public class AppointmentManager implements AppointmentService{
	
	AppointmentRepository appointmentRepository;
	ServiceRepository serviceRepository;
	UserRepository userRepository;
	private final ModelMapperService modelMapperService;
	
	@Override
	public void add(CreateAppointmentRequest createAppointmentRequest) {
	    User customer = userRepository.findById(createAppointmentRequest.getCustomerId())
	                                  .orElseThrow(() -> new RuntimeException("Customer not found"));
	    User worker = userRepository.findById(createAppointmentRequest.getWorkerId())
	                                .orElseThrow(() -> new RuntimeException("Worker not found"));

	    Appointment appointment = new Appointment();
	    appointment.setCustomer(customer);
	    appointment.setWorker(worker);
	    appointment.setAppointmentDate(createAppointmentRequest.getAppointmentDate());
	    appointment.setNote(createAppointmentRequest.getNote());

	    List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services =
	        serviceRepository.findByIdIn(createAppointmentRequest.getServiceIds());
	    appointment.setServices(services);
	    appointmentRepository.save(appointment);
	}
	@Override
	public List<GetAllAppointmentsResponse> getAll() {
	    List<Appointment> appointments = appointmentRepository.findAll();
	    return appointments.stream().map(appointment -> {
	        GetAllAppointmentsResponse response = new GetAllAppointmentsResponse();
	        response.setId(appointment.getId());
	        response.setAppointmentDate(appointment.getAppointmentDate());
	        response.setNote(appointment.getNote());

	        if (appointment.getCustomer() != null) {
	            response.setCustomerId(appointment.getCustomer().getId());
	        }
	        if (appointment.getWorker() != null) {
	            response.setWorkerId(appointment.getWorker().getId());
	        }

	        if (appointment.getServices() != null) {
	            response.setServiceIds(appointment.getServices().stream()
	                    .map(ybsGroup.kuaforRandevuSistemi.entities.concretes.Service::getId)
	                    .collect(Collectors.toList()));
	        }

	        return response;
	    }).collect(Collectors.toList());
	}

	@Override
	public GetByIdAppointmentResponse getById(int id) {
		Appointment appointment = appointmentRepository.findById(id).orElseThrow();
		GetByIdAppointmentResponse response = this.modelMapperService.forResponse().map(appointment, GetByIdAppointmentResponse.class);
		return response;
	}

	@Override
	public void delete(DeleteAppointmentRequest deleteAppointmentRequest) {
		this.appointmentRepository.deleteById(deleteAppointmentRequest.getId());
	}

	@Override
	public List<LocalTime> findAvailableSlots(int workerId, LocalDate appointmentDate, List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> selectedServices) {
		 LocalTime startTime = LocalTime.of(9, 0);
		    LocalTime endTime = LocalTime.of(21, 0);
		    List<LocalTime> allTimeSlots = new ArrayList<>();

		    // Tüm zaman dilimlerini oluştur
		    LocalTime slotTime = startTime;
		    while (slotTime.isBefore(endTime)) {
		        allTimeSlots.add(slotTime);
		        slotTime = slotTime.plusMinutes(10);
		    }

		    // Repository'den randevuları al
		    List<Appointment> appointments = appointmentRepository.findAllByWorkerIdAndAppointmentDateBetween(
		            workerId, appointmentDate.atTime(startTime), appointmentDate.atTime(endTime));

		    // Mevcut randevular için zaman dilimlerini kaldır
		    appointments.forEach(appointment -> {
		        LocalTime appointmentStart = appointment.getAppointmentDate().toLocalTime();
		        int serviceDuration = calculateTotalDuration(appointment.getServices());
		        LocalTime timeSlot = appointmentStart;
		        while (serviceDuration > 0) {
		            allTimeSlots.remove(timeSlot);
		            timeSlot = timeSlot.plusMinutes(10);
		            serviceDuration -= 10;
		        }
		    });

		    int customerServiceDuration = calculateTotalDuration(selectedServices);

		    // Müşteri için uygun zaman dilimlerini bul
		    return allTimeSlots.stream()
		        .filter(slot -> isSlotAvailable(slot, customerServiceDuration, allTimeSlots, appointments))
		        .collect(Collectors.toList());
	}
	

	private int calculateTotalDuration(List<ybsGroup.kuaforRandevuSistemi.entities.concretes.Service> services) {
	    int totalDuration = 0;
	    for (ybsGroup.kuaforRandevuSistemi.entities.concretes.Service service : services) {
	        totalDuration += service.getDuration();
	    }
	    return totalDuration;
	}

	private boolean isSlotAvailable(LocalTime slot, int duration, List<LocalTime> allTimeSlots ,List<Appointment> appointments) {
		LocalTime endSlot = slot.plusMinutes(duration);

	    for (Appointment appointment : appointments) {
	        LocalTime appointmentStart = appointment.getAppointmentDate().toLocalTime();
	        LocalTime appointmentEnd = appointmentStart.plusMinutes(calculateTotalDuration(appointment.getServices()));

	        // Mevcut randevu ile çakışma kontrolü
	        if ((slot.isBefore(appointmentEnd) && slot.isAfter(appointmentStart)) || 
	            (endSlot.isAfter(appointmentStart) && endSlot.isBefore(appointmentEnd)) ||
	            (slot.equals(appointmentStart) || endSlot.equals(appointmentEnd))) {
	            return false; // Çakışma var
	        }

	        // Randevudan önceki zaman dilimlerini kontrol et
	        LocalTime bufferStart = appointmentStart.minusMinutes(duration);
	        if (slot.isAfter(bufferStart) && slot.isBefore(appointmentStart)) {
	            return false; // Randevu için gereken buffer süresi
	        }
	    }

	    return allTimeSlots.contains(slot);
	}
}