package com.example.api.web.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.dto.AdresseDTO;
import com.example.api.service.AdresseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/adresses")
@AllArgsConstructor

// * para o teste
@CrossOrigin("*")
public class AdresseController {

	private AdresseService service;

	@PostMapping(value = "/{id}")
	public void create(@RequestBody AdresseDTO dto, @PathVariable Long id) {
		service.create(dto, id);
	}

	@PatchMapping
	public void update(@RequestBody AdresseDTO dto) {
		service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
