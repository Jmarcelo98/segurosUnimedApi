package com.example.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.Customer;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query(value = "SELECT c FROM Customer c " +
			"WHERE (:name is null or upper(c.name) = :name) " +
			"AND (:gender is null or c.gender = :gender)" +
			"AND (:email is null or upper(c.email) = :email)")
	Page<Customer> findAllByFilter(@Param(value = "name") String name, @Param(value = "gender") String gender, @Param(value = "email") String email, Pageable pageable);
	Page<Customer> findAllByOrderByNameAsc(Pageable pageable);

}
