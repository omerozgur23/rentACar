package io.kodlama.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.core.utilities.exceptions.BusinessException;
import io.kodlama.dataAccess.abstratcs.BrandRepository;

@Service
public class BrandBusinessRules {
	@Autowired
	private BrandRepository brandRepository;

	// Marka ismi tekrar ediyor mu kontrolü
	public void checkIfBrandNameExists(String name) {
		if (this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists"); // Java exception types araştır
		}
	}
}
