package com.example.api.service;

import org.springframework.stereotype.Service;

import com.example.api.domain.Adresse;
import com.example.api.domain.Customer;
import com.example.api.domain.dto.AdresseDTO;
import com.example.api.repository.AdresseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdresseService {

	private AdresseRepository repository;

	public Adresse create(AdresseDTO dto, Customer customer) {

		var adresse = Adresse.builder().id(null).zipCode(dto.getZipCode()).complement(dto.getComplement())
				.district(dto.getDistrict()).uf(dto.getUf()).publicPlace(dto.getPublicPlace())
				.locality(dto.getLocality()).customer(customer).build();

		repository.save(adresse);

		return adresse;

	}

}
