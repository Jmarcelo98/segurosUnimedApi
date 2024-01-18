package com.example.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.api.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query(value = "SELECT c FROM Customer c " + "LEFT JOIN c.adresses a "
			+ "WHERE (:name is null or upper(c.name) = :name) "
			+ "AND (:gender is null or c.gender = :gender)" 
			+ "AND (:email is null or upper(c.email) = :email) "
			+ "AND (:uf is null or upper(a.uf) = :uf) " 
			+ "AND (:locality is null or upper(a.locality) = :locality) " )
	Page<Customer> findAllByFilter(@Param(value = "name") String name, 
			@Param(value = "gender") String gender,
			@Param(value = "email") String email, 
			@Param(value = "uf") String uf,
			@Param(value = "locality") String locality, 
			Pageable pageable);

	Page<Customer> findAllByOrderByNameAsc(Pageable pageable);

	Boolean existsByEmailIgnoreCase(String email);

	Boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

}
