package com.compasso.estados.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.compasso.estados.modelo.Estado;

public class EstadoDto {
	
	private String nome;
	private String capital;
	private String regiao;
	private long populacao;
	private double area;
	
	
	public EstadoDto(Estado estado) {
		this.nome = estado.getNome();
		this.capital = estado.getCapital();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.area = estado.getArea();
	}
	
	public static List<EstadoDto> converter (List<Estado> estados){
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}

	public long getPopulacao() {
		return populacao;
	}

	public double getArea() {
		return area;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public String getCapital() {
		return capital;
	}	
}
