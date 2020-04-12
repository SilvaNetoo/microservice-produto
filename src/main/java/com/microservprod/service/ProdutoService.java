package com.microservprod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservprod.domain.Produto;
import com.microservprod.exceptions.ObjectNotFoundException;
import com.microservprod.repositories.UsuarioRepository;

@Service
public class ProdutoService {

	@Autowired
	private UsuarioRepository repo;

	public List<Produto> buscartodos() {
		return repo.findAll();
	}

	public Produto buscar(Integer id) {
		Optional<Produto> prod = repo.findById(id);
		return prod.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Produto inserir(Produto prod) {
		prod.setId(null);
		return repo.save(prod);
	}

	public Produto atualizar(Produto prod) {
		buscar(prod.getId());
		return repo.save(prod);
	}

	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);
	}

}