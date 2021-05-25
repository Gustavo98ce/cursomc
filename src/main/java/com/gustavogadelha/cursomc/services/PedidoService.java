package com.gustavogadelha.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavogadelha.cursomc.domain.Pedido;
import com.gustavogadelha.cursomc.repositories.PedidoRepository;
import com.gustavogadelha.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(" Objeto nao encontrado! Id : "+ id
				+", tipo: "+ Pedido.class.getName()) );
		
	}
}
