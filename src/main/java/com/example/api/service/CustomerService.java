package com.example.api.service;

import java.util.List;
import java.util.Optional;

import com.example.api.domain.dto.FilterDTO;
import com.example.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;

@Service
@AllArgsConstructor
public class CustomerService {

	CustomerRepository repository;

	public Page<Customer> findAll(Pageable pageable) {
		return repository.findAllByOrderByNameAsc(pageable);
	}

	public Page<Customer> findAllByFilter(FilterDTO filter, Pageable pageable) {
		return repository.findAllByFilter(filter.getName() == null ? null : filter.getName().toUpperCase(), filter.getGender(), filter.getEmail() == null ? null : filter.getEmail().toUpperCase(), pageable);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
