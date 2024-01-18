package com.example.api.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.api.domain.dto.CepConsultDTO;
import com.example.api.handlers.ResourceNotFoundException;

@RestController
@RequestMapping("search-cep")

//* para o teste
@CrossOrigin("*")
public class ViaCepAPI {

	@GetMapping("{cep}")
	public CepConsultDTO consultaCep(@PathVariable("cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CepConsultDTO> resp = restTemplate
					.getForEntity(String.format("https://viacep.com.br/ws/%s/json", cep), CepConsultDTO.class);
			return resp.getBody();
		}

		catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("CEP inválido: " + cep);
		}
	}

}
