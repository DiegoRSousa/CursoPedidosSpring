package com.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.dominio.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
}
