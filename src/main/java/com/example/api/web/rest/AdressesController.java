package com.example.api.web.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.AdresseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/adresses")
@AllArgsConstructor

// * para o teste
@CrossOrigin("*")
public class AdressesController {

	private AdresseService service;

}
