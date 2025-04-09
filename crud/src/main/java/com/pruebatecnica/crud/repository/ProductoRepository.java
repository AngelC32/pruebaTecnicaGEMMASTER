package com.pruebatecnica.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.pruebatecnica.crud.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto,Long>{
    
}
