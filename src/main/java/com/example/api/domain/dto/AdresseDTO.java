package com.example.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {

	private String zipCode;

	private String publicPlace;

	private String complement;

	private String district;

	private String locality;

	private String uf;

}
