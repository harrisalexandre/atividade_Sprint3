package com.compasso.carros.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.carros.controller.dto.CarroDto;
import com.compasso.carros.controller.form.BuscaCarroForm;
import com.compasso.carros.controller.form.CarroForm;
import com.compasso.carros.modelo.Carro;
import com.compasso.carros.repository.CarroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cars")
@Api(value="API Carros Swagger")
@CrossOrigin(origins="*")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;	
	
	//listar
	@GetMapping
	@ApiOperation(value="Este metodo retorna lista de carros")
	public ResponseEntity<?> lista(BuscaCarroForm form, Pageable pageable){

		List<Carro> carros = carroRepository.findAll(form.toSpec(),pageable).getContent();
		if(carros.size()> 0) {
			return ResponseEntity.ok(CarroDto.converter(carros));	
		}
		return ResponseEntity.notFound().build();
	}
	
	//cadastrar
	@PostMapping
	@ApiOperation(value="Este metodo cadastra carros")
	public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm carroForm, UriComponentsBuilder uriBuilder) {
		Carro carro = carroForm.converter(carroForm);
		carroRepository.save(carro);
		
		URI uri = uriBuilder.path("/api/cars/{id}").buildAndExpand(carro.getChassi()).toUri();
		
		return ResponseEntity.created(uri).body(new CarroDto(carro));
	}
}
