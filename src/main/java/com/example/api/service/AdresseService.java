package com.example.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api.domain.Adresse;
import com.example.api.domain.Customer;
import com.example.api.domain.dto.AdresseDTO;
import com.example.api.handlers.ResourceNotFoundException;
import com.example.api.repository.AdresseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdresseService {

	private AdresseRepository repository;

	private CustomerService customerService;

	public void create(AdresseDTO dto, Long idCustomer) {

		var customer = findById(idCustomer);

		var adresse = Adresse.builder().id(null).zipCode(dto.getZipCode()).complement(dto.getComplement())
				.district(dto.getDistrict()).uf(dto.getUf()).publicPlace(dto.getPublicPlace())
				.locality(dto.getLocality()).customer(customer).build();

		repository.save(adresse);

	}

	public List<String> getAllUf() {
		return repository.findAllUf();	
	}
	
	public void update(AdresseDTO dto) {

		var adresse = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado"));
		
		adresse.setComplement(dto.getComplement());
		adresse.setDistrict(dto.getDistrict());
		adresse.setLocality(dto.getLocality());
		adresse.setPublicPlace(dto.getPublicPlace());
		adresse.setUf(dto.getUf());
		adresse.setZipCode(dto.getZipCode());

		repository.save(adresse);

	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}


//	private

	private Customer findById(Long id) {
		return customerService.findById(id);
	}

}
