package com.pruebatecnica.crud.services;

import java.util.List;
import java.util.Optional;

import com.pruebatecnica.crud.models.Producto;

public interface IProductoService {
    Producto create(Producto producto);
    List<Producto> findAll();
    Optional<Producto> delete(Long id);
    Optional<Producto> update (Long id, Producto producto);
    Optional<Producto> findById(Long id);
}
