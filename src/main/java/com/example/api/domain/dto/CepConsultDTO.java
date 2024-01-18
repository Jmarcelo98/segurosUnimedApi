package com.example.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CepConsultDTO {

	@JsonProperty("cep")
	private String zipCode;

	@JsonProperty("logradouro")
	private String publicPlace;

	@JsonProperty("complemento")
	private String complement;

	@JsonProperty("bairro")
	private String district;

	@JsonProperty("localidade")
	private String locality;

	@JsonProperty("uf")
	private String uf;
}
