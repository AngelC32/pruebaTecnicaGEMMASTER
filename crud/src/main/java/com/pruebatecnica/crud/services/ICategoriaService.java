package com.pruebatecnica.crud.services;

import java.util.List;
import java.util.Optional;

import com.pruebatecnica.crud.models.Categoria;

public interface ICategoriaService {
 List<Categoria> findAll();
 Optional<Categoria> findById(Long id);
}
