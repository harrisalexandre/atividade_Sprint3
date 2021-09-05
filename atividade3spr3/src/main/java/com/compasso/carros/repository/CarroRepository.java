package com.compasso.carros.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compasso.carros.modelo.Carro;

public interface CarroRepository extends PagingAndSortingRepository<Carro, String>, JpaSpecificationExecutor<Carro> {
	
}
