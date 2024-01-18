package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.Adresse;
import com.example.api.domain.Customer;

public interface AdresseRepository extends CrudRepository<Adresse, Long> {

	Boolean existsByIdAndCustomer(String id, Customer customer);

	@Query(value = "SELECT DISTINCT a.uf FROM Adresse a ")
	List<String> findAllUf();

}
