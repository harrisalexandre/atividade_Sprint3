package com.compasso.carros.controller.form;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import com.compasso.carros.modelo.Carro;

public class CarroForm {
	
	@NotBlank
	private String chassi;
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private int ano;
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Carro converter(CarroForm carroForm) {
		return new Carro(chassi, nome, marca, cor, valor, ano);
	}
}
