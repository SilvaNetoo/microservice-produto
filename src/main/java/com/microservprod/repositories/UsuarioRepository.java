package com.microservprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservprod.domain.Produto;

@Repository
public interface UsuarioRepository extends JpaRepository<Produto, Integer> {

}