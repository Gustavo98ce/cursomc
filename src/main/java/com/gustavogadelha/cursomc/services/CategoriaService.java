package com.gustavogadelha.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gustavogadelha.cursomc.domain.Categoria;
import com.gustavogadelha.cursomc.repositories.CategoriaRepository;

public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
