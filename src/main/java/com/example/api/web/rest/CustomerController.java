package com.example.api.web.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.Customer;
import com.example.api.domain.dto.CustomerDTO;
import com.example.api.domain.dto.FilterDTO;
import com.example.api.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor

// * para o teste
@CrossOrigin("*")
public class CustomerController {

	private CustomerService service;

	@GetMapping
	public Page<Customer> findAll() {
		return service.findAll(null);
	}

	@PostMapping("/filter")
	public Page<Customer> findAllByFilter(@RequestBody FilterDTO filter, Pageable pageable) {
		return service.findAllByFilter(filter, pageable);
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public void create(@RequestBody CustomerDTO dto) {
		service.create(dto);
	}

	@PatchMapping
	public void update(@RequestBody CustomerDTO dto) {
		service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
