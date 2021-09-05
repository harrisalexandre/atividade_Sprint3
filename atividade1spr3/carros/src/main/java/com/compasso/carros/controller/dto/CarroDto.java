package com.compasso.carros.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.compasso.carros.modelo.Carro;

public class CarroDto {
	
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private int ano;
	
	public CarroDto(Carro carro) {
		this.nome = carro.getNome();
		this.marca = carro.getMarca();
		this.cor = carro.getCor();
		this.valor = carro.getValor();
		this.ano = carro.getAno();
	}

	public static List<CarroDto> converter (List<Carro> carros){
		return carros.stream().map(CarroDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getAno() {
		return ano;
	}
}
