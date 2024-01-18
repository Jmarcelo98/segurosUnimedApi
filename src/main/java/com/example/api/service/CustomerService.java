package com.example.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Adresse;
import com.example.api.domain.Customer;
import com.example.api.domain.dto.CepConsultDTO;
import com.example.api.domain.dto.CustomerDTO;
import com.example.api.domain.dto.FilterDTO;
import com.example.api.handlers.BusinessException;
import com.example.api.handlers.ResourceNotFoundException;
import com.example.api.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private CustomerRepository repository;

	private AdresseService adresseService;

	public Page<Customer> findAll(Pageable pageable) {
		return repository.findAllByOrderByNameAsc(pageable);
	}

	public Page<Customer> findAllByFilter(FilterDTO filter, Pageable pageable) {
		return repository.findAllByFilter(filter.getName() == null ? null : filter.getName().toUpperCase(),
				filter.getGender(), filter.getEmail() == null ? null : filter.getEmail().toUpperCase(), pageable);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public void create(CustomerDTO dto) {

		existsByNameAndEmail(dto);

		var customer = Customer.builder().name(dto.getName()).email(dto.getEmail()).gender(dto.getGender()).id(null)
				.build();

		repository.save(customer);
		
//		createAdresse(null, null)

	}

	public void update(CustomerDTO dto) {

		var customer = findCustomerById(dto.getId());

		existsByEmailUpdate(dto);

		customer.setGender(dto.getGender());

		repository.save(customer);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	// privates

	private Adresse createAdresse(CepConsultDTO dto, Customer customer) {
		return adresseService.create(dto,customer);
	}

	private Customer findCustomerById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by email"));
	}

	private void existsByEmailUpdate(CustomerDTO dto) {

		if (repository.existsByEmailIgnoreCaseAndIdNot(dto.getEmail(), dto.getId())) {
			throw new BusinessException("E-mail já cadastrado");
		}

	}

	private void existsByNameAndEmail(CustomerDTO dto) {

		if (repository.existsByEmailIgnoreCase(dto.getEmail())) {
			throw new BusinessException("E-mail já cadastrado");
		}

	}

}
