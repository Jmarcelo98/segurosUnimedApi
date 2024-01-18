package com.example.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotEmpty
//	@JsonProperty("cep")
	private String zipCode;

	@Column(nullable = false)
	@NotEmpty
//	@JsonProperty("logradouro")
	private String publicPlace;

	@Column(nullable = false)
//	@JsonProperty("complemento")
	private String complement;

	@Column(nullable = false)
	@NotEmpty
//	@JsonProperty("bairro")
	private String district;

	@Column(nullable = false)
	@NotEmpty
//	@JsonProperty("localidade")
	private String locality;

	@Column(nullable = false)
	@NotEmpty
//	@JsonProperty("uf")
	private String uf;

	@ManyToOne
	@JoinColumn(name = "id_customer", nullable = false)
	@JsonBackReference
	private Customer customer;

}
