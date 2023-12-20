package ybsGroup.kuaforRandevuSistemi.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.core.utilities.exceptions.BusinessException;
import ybsGroup.kuaforRandevuSistemi.dataAccess.abstracts.HairdresserRepository;

@AllArgsConstructor
@Service
public class HairdresserBusinessRules {
	private HairdresserRepository userRepository;
	
	public void checkIfHairdresserEmailExists(String email) {
		if (userRepository.existsByEmail(email)) {
			throw new BusinessException("Email already exists"); 
		}
		
	}
}
