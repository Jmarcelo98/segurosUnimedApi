package com.example.api.web.rest;

import com.example.api.domain.dto.FilterDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor

// * para o teste
@CrossOrigin("*")
public class CustomerController {

	private CustomerService service;

	@GetMapping
	public Page<Customer> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}
	@PostMapping("/filter")
	public Page<Customer> findAllByFilter(@RequestBody FilterDTO filter, Pageable pageable) {
		return service.findAllByFilter(filter, pageable);
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

}
