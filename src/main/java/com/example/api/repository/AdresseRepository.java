package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.Adresse;
import com.example.api.domain.Customer;

public interface AdresseRepository extends CrudRepository<Adresse, Long> {

	Boolean existsByIdAndCustomer(String id, Customer customer);

}
