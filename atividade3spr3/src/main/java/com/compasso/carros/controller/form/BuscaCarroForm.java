package com.compasso.carros.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.compasso.carros.modelo.Carro;

public class BuscaCarroForm {
	
	private String nome;
	private String marca;
	private String cor;

	public BuscaCarroForm(String nome, String marca, String cor) {
		this.nome = nome;
		this.marca = marca;
		this.cor = cor;
	}

	public Specification<Carro> toSpec() {
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(StringUtils.hasText(nome)) {
				Path<String> campoNome = root.<String>get("nome");
				Predicate predicadoNome = builder.equal(campoNome, nome);
				predicados.add(predicadoNome);
			}
			if(StringUtils.hasText(marca)) {
				Path<String> campoMarca = root.<String>get("marca");
				Predicate predicadoMarca = builder.equal(campoMarca, marca);
				predicados.add(predicadoMarca);
			}			
			if(StringUtils.hasText(cor)) {
				Path<String> campoCor = root.<String>get("cor");
				Predicate predicadoCor = builder.equal(campoCor, cor);
				predicados.add(predicadoCor);
			}			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
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
}
